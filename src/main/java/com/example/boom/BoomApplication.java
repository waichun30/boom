package com.example.boom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoomApplication {

    public static void main(String[] args) {

        SpringApplication.run(BoomApplication.class, args);
        System.out.print("started");
    }

}
