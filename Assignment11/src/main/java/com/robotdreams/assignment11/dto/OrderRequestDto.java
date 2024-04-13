package com.robotdreams.assignment11.dto;

import java.io.Serializable;
import java.util.List;

public record OrderRequestDto(List<Long> productIdList,
                              String description, Long userId, String orderNumber) implements Serializable {
}