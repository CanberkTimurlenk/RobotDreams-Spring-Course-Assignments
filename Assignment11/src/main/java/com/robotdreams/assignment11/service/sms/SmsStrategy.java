package com.robotdreams.assignment11.service.sms;

import com.robotdreams.assignment11.entity.Order;
import com.robotdreams.assignment11.entity.User;

public interface SmsStrategy {

    public void sendOrderCreatedSms(Order order, User user);

    public void sendUserUpdatedSms(User user);

}
