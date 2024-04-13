package com.robotdreams.assignment11.dto;

import java.io.Serializable;


public record ProductDetailRequestDto(String productInfo, String productSerialNumber) implements Serializable {
}