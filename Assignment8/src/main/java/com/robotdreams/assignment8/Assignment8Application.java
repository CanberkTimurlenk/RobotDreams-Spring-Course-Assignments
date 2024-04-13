package com.robotdreams.assignment8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Assignment8Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment8Application.class, args);
    }

}
