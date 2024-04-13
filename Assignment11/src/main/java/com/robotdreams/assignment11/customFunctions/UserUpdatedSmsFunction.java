package com.robotdreams.assignment11.customFunctions;

@FunctionalInterface
public interface UserUpdatedSmsFunction {
    String replace(String template, String firstname, String lastname);
}
