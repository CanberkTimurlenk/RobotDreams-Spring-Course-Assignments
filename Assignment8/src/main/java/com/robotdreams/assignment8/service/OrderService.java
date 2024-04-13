package com.robotdreams.assignment8.service;

import com.robotdreams.assignment8.dto.OrderRequestDto;
import com.robotdreams.assignment8.entity.Order;
import com.robotdreams.assignment8.entity.Product;
import com.robotdreams.assignment8.entity.User;
import com.robotdreams.assignment8.exceptionHandling.GeneralException;
import com.robotdreams.assignment8.exceptionHandling.InsufficientOrderAmountException;
import com.robotdreams.assignment8.repository.OrderRepository;
import com.robotdreams.assignment8.service.mapper.OrderMapper;
import com.robotdreams.assignment8.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final ProductService productService;
    private final OrderProductService orderProductService;
    private final SmsService smsService;
    private final UserService userService;


    public OrderService(OrderRepository orderRepository, OrderMapper mapper, ProductService productService, OrderProductService orderProductService, SmsService smsService, UserService userService) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.smsService = smsService;
        this.userService = userService;
    }

    public void save(OrderRequestDto orderRequestDto) {

        List<Long> productIds = orderRequestDto.getProductIdList();

        // persist order
        Order order = mapper.OrderRequestDtoToOrder(orderRequestDto);
        orderRepository.save(order);

        // get products
        List<Product> products = productIds.stream()
                                    .map(productService::findById)
                                    .toList();

        try {
            checkIfOrderAmountIsSufficent(products);
        } catch (InsufficientOrderAmountException e) {
            System.out.println("Logged !");
            throw new GeneralException("The order amount is insufficient ");
        }

        // persist orderProducts
        orderProductService.saveAll(products,order);

        // find user with ID
        User user = userService.findById(orderRequestDto.getUserId()).get();

        // send SMS
        smsService.sendSms(order, user);

    }

    private void checkIfOrderAmountIsSufficent(List<Product> products)
        throws InsufficientOrderAmountException{

        double minOrderAmount = 50.0; // proje genelinde business ile alakalı bu tür genel kullanılabilecek değerlerim varsa
        // örneğin buradaki minimum sipariş tutarı kısıtımız şudur... gibi
        // sanırım const olarak tanımlamlıyım, peki ayrı bir package mı açmalıyım bu tür değerler için ?

        var total = products.stream()
                    .map(Product::getPrice)
                    .reduce(0.0,Double::sum);

        if(minOrderAmount > total)
            throw new InsufficientOrderAmountException(total);

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
