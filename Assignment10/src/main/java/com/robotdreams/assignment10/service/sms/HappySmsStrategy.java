package com.robotdreams.assignment10.service.sms;

import com.robotdreams.assignment10.customFunctions.OrderCreatedSmsFunction;
import com.robotdreams.assignment10.customFunctions.UserUpdatedSmsFunction;
import com.robotdreams.assignment10.entity.Order;
import com.robotdreams.assignment10.entity.User;
import com.robotdreams.assignment10.service.sms.SmsStrategy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class HappySmsStrategy implements SmsStrategy {

    @Async
    public void sendOrderCreatedSms(Order order, User user) {

        OrderCreatedSmsFunction smsReplaceFunction = (template, firstname, email, orderNumber) ->
                template.replace("NAME", firstname).replace("EMAIL", email).replace("ORDERNUMBER", orderNumber);

        var orderNumber = order.getOrderNumber();
        var name = user.getFirstname();
        var email = user.getEmail();

        // mocking
        var phoneNumber = user.getPhoneNumber();

        String smsBody = "Premium kullanıcımız, Sevgili NAME siparişini aldık, Siparişinin numarası: ORDERNUMBER . Siparişinin detaylarına EMAIL adresine gönderdiğimiz mailden ulaşabilirsin.";

        smsReplaceFunction.replace(smsBody, name, email, orderNumber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public void sendUserUpdatedSms(User user) {

        UserUpdatedSmsFunction smsReplaceFunction = (template, firstname, lastname) ->
                template.replace("FIRSTNAME", firstname).replace("LASTNAME", lastname);

        String firstname = user.getFirstname();
        String lastname = user.getLastname();

        String smsBody = "Premium kullanıcımız, Sevgili FIRSTNAME LASTNAME kullanıcı bilgilerin güncellenmiştir.";

        smsReplaceFunction.replace(smsBody, firstname, lastname);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
