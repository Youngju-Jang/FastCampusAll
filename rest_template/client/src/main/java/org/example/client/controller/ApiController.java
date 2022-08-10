package org.example.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiCh9")
public class ApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
