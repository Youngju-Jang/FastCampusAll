package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiCh65/public")
public class publicController {

    @GetMapping("/hello")
    public String hello(){
        return "public hello";
    }
}
