package com.robotdreams.assignment11.exceptionHandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
