package com.robotdreams.assignment10.dto;

import java.io.Serializable;

public record OrderResponseDto(String description, BaseResponseDto baseResponseDto) implements Serializable {
}