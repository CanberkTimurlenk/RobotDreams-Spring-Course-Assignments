package com.robotdreams.assignment4.service;

import com.robotdreams.assignment4.entity.Product;
import com.robotdreams.assignment4.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean createProduct(Product product) {
        return productRepository.create(product).getId() > 0;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
