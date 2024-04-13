package com.robotdreams.assignment10.service.sms;

import com.robotdreams.assignment10.entity.Order;
import com.robotdreams.assignment10.entity.User;

public class SmsSender {
    private final SmsStrategy smsStrategy;

    public SmsSender(SmsStrategy smsStrategy) {
        this.smsStrategy = smsStrategy;
    }

    public void sendOrderCreatedSms(Order order, User user) {
        smsStrategy.sendOrderCreatedSms(order, user);
    }

    public void sendUserUpdatedSms(User user) {
        smsStrategy.sendUserUpdatedSms(user);
    }

}