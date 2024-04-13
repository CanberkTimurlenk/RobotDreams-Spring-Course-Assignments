package com.robotdreams.assignment7.customFunctions;

@FunctionalInterface
public interface SmsFunction {
    String replace(String template, String name, String email, String orderNumber);
}
