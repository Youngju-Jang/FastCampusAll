package com.example.hello.controller;

import com.example.hello.annotation.Decode;
import com.example.hello.annotation.Timer;
import com.example.hello.dto.ch5_User3;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        return id+ " " + name;
    }

    @PostMapping("/post")
    public ch5_User3 post(@RequestBody ch5_User3 user){
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        // db logic 1초걸린다고치고
        Thread.sleep(1000*2);
    }

    @Decode
    @PutMapping("/put")
    public ch5_User3 put(@RequestBody ch5_User3 user){
        System.out.println("put");
        System.out.println(user);
        return user;
    }
}
