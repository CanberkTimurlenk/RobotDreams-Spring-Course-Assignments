package com.robotdreams.assignment10.customFunctions;

@FunctionalInterface
public interface UserUpdatedSmsFunction {
    String replace(String template, String firstname, String lastname);
}
