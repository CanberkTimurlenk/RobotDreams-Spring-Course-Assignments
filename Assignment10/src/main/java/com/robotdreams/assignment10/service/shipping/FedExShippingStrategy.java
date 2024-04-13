package com.robotdreams.assignment10.service.shipping;

public class FedExShippingStrategy implements ShippingStrategy {
    @Override
    public double calculate(double weight) {
        return weight / 4 + 20;
    }
}
