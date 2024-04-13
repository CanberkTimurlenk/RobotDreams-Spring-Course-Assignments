package com.robotdreams.assignment10.service;

import com.robotdreams.assignment10.dto.OrderRequestDto;
import com.robotdreams.assignment10.entity.Order;
import com.robotdreams.assignment10.entity.Product;
import com.robotdreams.assignment10.entity.User;
import com.robotdreams.assignment10.exceptionHandling.GeneralException;
import com.robotdreams.assignment10.exceptionHandling.OrderException;
import com.robotdreams.assignment10.repository.OrderRepository;
import com.robotdreams.assignment10.service.constant.ShippingConstants;
import com.robotdreams.assignment10.service.mapper.OrderMapper;
import com.robotdreams.assignment10.dto.OrderResponseDto;
import com.robotdreams.assignment10.service.shipping.*;
import com.robotdreams.assignment10.service.sms.HappySmsStrategy;
import com.robotdreams.assignment10.service.sms.SmsSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final ProductService productService;
    private final OrderProductService orderProductService;
    private final UserService userService;

    public void save(OrderRequestDto orderRequestDto) {

        List<Long> productIds = orderRequestDto.productIdList();

        // persist order
        Order order = mapper.OrderRequestDtoToOrder(orderRequestDto);

        // find user with ID
        User user = userService.findById(orderRequestDto.userId()).get();

        // get products
        List<Product> products = productIds.stream()
                .map(productService::findById)
                .toList();

        // set shipment cost
        order.setShippingCost(getShippingOffer(products, user));

        // persist order
        orderRepository.save(order);

        try {
            checkIfOrderAmountIsSufficent(products);
            checkIfOrderHasMoreThanThreeProductsInSameCategory(products);
        } catch (OrderException e) {
            System.out.println("an exception" + e.getMessage());
            throw new GeneralException("exception occured" + e.getMessage());
        }

        // persist orderProducts
        orderProductService.saveAll(products, order);

        // send SMS
        new SmsSender(new HappySmsStrategy()).sendOrderCreatedSms(order, user);
    }

    private double getShippingOffer(List<Product> products, User user) {

        double totalWeight = products
                .stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        if (user.isPremium())
            return ShippingConstants.PREMIUM_USER_SHIPMENT_COST;

        return calculateCargoPrice(totalWeight);
    }

    private double calculateCargoPrice(double totalWeight) {

        if (totalWeight > 250)
            return new ShippingCostCalculator(new FedExShippingStrategy()).getCost(totalWeight);

        else if (totalWeight > 100)
            return new ShippingCostCalculator(new YurticiShippingStrategy()).getCost(totalWeight);

        return new ShippingCostCalculator(new MngShippingStrategy()).getCost(totalWeight);
    }

    public void checkIfOrderAmountIsSufficent(List<Product> products)
            throws OrderException {

        double minOrderAmount = 50.0;

        double total = products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        if (minOrderAmount > total)
            throw new OrderException("The order amount of " + total + " is lower than the minimum order amount.");
    }

    public void checkIfOrderHasMoreThanThreeProductsInSameCategory(List<Product> products)
            throws OrderException {

        // Business kuralı: bir sipariş aynı kategoriden en fazla üç ürün içerebilir

        Map<String, Long> categoryProductCount = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        StringBuilder message = new StringBuilder();

        // üçten fazla aynı kategoriden olan ürün varsa isimlerini bir string içerisinde topluyorum
        categoryProductCount.forEach((category, count) -> {
            if (count > 3)
                message.append(category)
                        .append(" : ")
                        .append(count)
                        .append(" ");
        });

        String resultMessage = message.toString();

        if (!message.isEmpty())
            throw new OrderException(("An order must include a maximum of 3 products from a single category. Violations: " + message).trim());
    }

    public Optional<List<OrderResponseDto>> findAll() {
        var responseDtos = StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .map(mapper::orderToOrderResponseDto)
                .toList();

        return Optional.of(responseDtos);
    }

    public void delete(long orderId) {
        orderRepository.deleteById(orderId);
    }
}
