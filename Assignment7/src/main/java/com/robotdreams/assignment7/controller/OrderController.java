package com.robotdreams.assignment7.controller;


import com.robotdreams.assignment7.dto.OrderRequestDto;
import com.robotdreams.assignment7.dto.OrderResponseDto;
import com.robotdreams.assignment7.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String create(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.save(orderRequestDto)
                ? "Successfully Created!"
                : "An unexpected error occured!";
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> findAll() {

        var orderResponseDtos = orderService.findAll();

        if (orderResponseDtos.isPresent())
            return ResponseEntity.ok(orderResponseDtos.get());

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public void delete(@RequestParam long orderId) {
        orderService.delete(orderId);
    }
}
