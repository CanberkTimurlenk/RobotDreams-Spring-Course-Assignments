package com.robotdreams.assignment10.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

public record OrderRequestDto(List<Long> productIdList,
                              String description, Long userId, String orderNumber) implements Serializable {
}