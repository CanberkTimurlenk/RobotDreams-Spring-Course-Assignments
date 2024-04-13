package com.robotdreams.assignment10.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


public record UserRequestDto(String firstname, String lastname, String email, String phoneNumber,
                             String address) implements Serializable {
}