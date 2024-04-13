package com.robotdreams.assignment10.dto;


public record UserResponseDto(String firstname, String lastname,
                              String email, String phoneNumber, String address, boolean premium) {

}

