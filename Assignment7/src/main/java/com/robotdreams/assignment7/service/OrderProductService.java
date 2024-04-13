package com.robotdreams.assignment7.service;

import com.robotdreams.assignment7.entity.OrderProduct;
import com.robotdreams.assignment7.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public Boolean save(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct).getId() > 0;
    }
}
