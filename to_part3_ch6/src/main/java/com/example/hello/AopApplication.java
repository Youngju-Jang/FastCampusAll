package com.example.hello;

import com.example.hello.controller.RestApiController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);

        System.out.println(Base64.getEncoder().encodeToString("steve@gmail.com".getBytes()));
        // c3RldmVAZ21haWwuY29t encoding하면 이거임

    }
}
