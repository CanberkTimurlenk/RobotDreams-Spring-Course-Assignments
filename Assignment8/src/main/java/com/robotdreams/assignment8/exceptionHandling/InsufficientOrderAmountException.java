package com.robotdreams.assignment8.exceptionHandling;

public class InsufficientOrderAmountException extends BusinessException{
    public InsufficientOrderAmountException(double amount) {
        super("The order amount of " + amount + " is lower than the minimum order amount.");
    }
}
