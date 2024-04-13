package com.robotdreams.assignment11.dto;

import java.io.Serializable;

public record OrderResponseDto(String description, BaseResponseDto baseResponseDto) implements Serializable {
}