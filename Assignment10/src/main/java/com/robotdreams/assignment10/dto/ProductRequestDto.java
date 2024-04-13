package com.robotdreams.assignment10.dto;

import java.io.Serializable;

public record ProductRequestDto(String name, String category,
                                String photoUrl, String description, Double price,
                                ProductDetailRequestDto productDetail) implements Serializable {
}