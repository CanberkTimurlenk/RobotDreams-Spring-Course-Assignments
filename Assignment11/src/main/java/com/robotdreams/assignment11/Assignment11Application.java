package com.robotdreams.assignment11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Assignment11Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment11Application.class, args);
    }

}
