package com.robotdreams.assignment10.service;

import com.robotdreams.assignment10.entity.Order;
import com.robotdreams.assignment10.entity.OrderProduct;
import com.robotdreams.assignment10.entity.Product;
import com.robotdreams.assignment10.repository.OrderProductRepository;
import com.robotdreams.assignment10.repository.ProductRepository;
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
