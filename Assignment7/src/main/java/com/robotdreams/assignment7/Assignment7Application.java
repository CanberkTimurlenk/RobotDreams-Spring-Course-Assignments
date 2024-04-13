package com.robotdreams.assignment7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Assignment7Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment7Application.class, args);
    }

}
