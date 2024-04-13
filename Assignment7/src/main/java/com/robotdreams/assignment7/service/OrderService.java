package com.robotdreams.assignment7.service;

import com.robotdreams.assignment7.dto.OrderRequestDto;
import com.robotdreams.assignment7.entity.Order;
import com.robotdreams.assignment7.entity.OrderProduct;
import com.robotdreams.assignment7.entity.Product;
import com.robotdreams.assignment7.entity.User;
import com.robotdreams.assignment7.repository.OrderRepository;
import com.robotdreams.assignment7.service.mapper.OrderMapper;
import com.robotdreams.assignment7.dto.OrderResponseDto;
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

    public Boolean save(OrderRequestDto orderRequestDto) {

        // persist order
        Order order = mapper.OrderRequestDtoToOrder(orderRequestDto);
        orderRepository.save(order);

        // find product in the dto
        Product product = productService.findById(orderRequestDto.getProductId());

        // persist orderProduct
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);
        orderProductService.save(orderProduct);

        // find user with ID
        User user = userService.findById(orderRequestDto.getUserId()).get();
        // send SMS
        smsService.sendSms(order, user);

        // return true, if order have been created successfully. Otherwise false
        return order.getId() > 0
                && orderProduct.getId() > 0;
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
