package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}")
    public void Delete(@PathVariable String userId, @RequestParam String account){
        System.out.println("userId"+userId);
        System.out.println("account" + account);
    }

}
