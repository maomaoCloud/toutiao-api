package com.toutiaopoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToutiaoApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(ToutiaoApiApplication.class, args);
        System.out.print("server start");
    }
}
