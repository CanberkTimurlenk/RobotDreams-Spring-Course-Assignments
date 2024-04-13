package com.robotdreams.assignment11.dto;

import java.io.Serializable;

public record ProductRequestDto(String name, String category,
                                String photoUrl, String description, Double price,
                                ProductDetailRequestDto productDetail) implements Serializable {
}