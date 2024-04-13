package com.robotdreams.assignment11.dto;

import java.io.Serializable;


public record UserRequestDto(String firstname, String lastname, String email, String phoneNumber,
                             String address) implements Serializable {
}