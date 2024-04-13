package com.robotdreams.assignment10.service;

import com.robotdreams.assignment10.dto.ProductRequestDto;
import com.robotdreams.assignment10.dto.ProductResponseDto;
import com.robotdreams.assignment10.entity.Product;
import com.robotdreams.assignment10.exceptionHandling.GeneralException;
import com.robotdreams.assignment10.exceptionHandling.ProductException;
import com.robotdreams.assignment10.repository.ProductRepository;
import com.robotdreams.assignment10.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public boolean create(ProductRequestDto createProductRequestDto) {
        Product product = mapper.mapToProduct(createProductRequestDto);

        try {
            checkIfPriceIsValid(createProductRequestDto.price());
        } catch (ProductException e) {
            System.out.println("Logged!");
            throw new GeneralException("Invalid price");
        }
        return productRepository.save(product).getId() > 0;
    }

    public Optional<List<ProductResponseDto>> findAll() {

        var responseDtos = productRepository.findAll().stream()
                .map(mapper::productToProductResponseDto).toList();

        return Optional.of(responseDtos);
    }

    private void checkIfPriceIsValid(double price)
            throws ProductException {

        if (price <= 0.0)
            throw new ProductException("the price is invalid: " + price);
    }

    public Product findById(long id) {
        return productRepository.findById(id).get();
    }
}
