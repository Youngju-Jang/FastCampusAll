package com.example.hello.controller;

import com.example.hello.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // sisout 대신 이거씀  >>log.info
@RestController
@RequestMapping("/apich65/temp")
public class ApiUserController {


    @PostMapping("")
    public User user(@RequestBody User user){
        log.info("User : {}", user); // ,뒤에 객체를 toString하여 {}여기에 들어감

        return user;
    }
}
