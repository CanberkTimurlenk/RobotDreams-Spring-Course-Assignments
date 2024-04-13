package com.robotdreams.assignment10.service.sms;

import com.robotdreams.assignment10.entity.Order;
import com.robotdreams.assignment10.entity.User;

public interface SmsStrategy {

    public void sendOrderCreatedSms(Order order, User user);

    public void sendUserUpdatedSms(User user);

}
