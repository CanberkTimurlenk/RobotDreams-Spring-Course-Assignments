package com.robotdreams.assignment4.controller;

import com.robotdreams.assignment4.entity.Product;
import com.robotdreams.assignment4.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseBody
    public String create(@RequestBody Product product) {
        return productService.createProduct(product)
                ? "Successfully Created!"
                : "An unexpected error occured!";
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }
}