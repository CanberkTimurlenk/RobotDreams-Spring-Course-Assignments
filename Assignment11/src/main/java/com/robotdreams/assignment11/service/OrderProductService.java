package com.robotdreams.assignment11.service;

import com.robotdreams.assignment11.entity.Order;
import com.robotdreams.assignment11.entity.OrderProduct;
import com.robotdreams.assignment11.entity.Product;
import com.robotdreams.assignment11.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final ProductService productService;

    public void saveAll(List<Product> products, Order order) {
        var orderProducts = products.stream()
                .map(p -> {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setProduct(p);
                    orderProduct.setOrder(order);
                    return orderProduct;
                }).toList();

        orderProductRepository.saveAll(orderProducts);

    }
}
