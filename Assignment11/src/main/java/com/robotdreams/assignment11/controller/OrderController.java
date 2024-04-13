package com.robotdreams.assignment11.controller;


import com.robotdreams.assignment11.dto.OrderRequestDto;
import com.robotdreams.assignment11.dto.OrderResponseDto;
import com.robotdreams.assignment11.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity create(@RequestBody OrderRequestDto orderRequestDto) {

        orderService.save(orderRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);

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
