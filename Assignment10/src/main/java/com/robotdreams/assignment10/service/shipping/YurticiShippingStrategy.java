package com.robotdreams.assignment10.service.shipping;

public class YurticiShippingStrategy implements ShippingStrategy {
    @Override
    public double calculate(double weight) {
        return weight / 2 + 5;
    }
}
