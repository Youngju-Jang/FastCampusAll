package com.example.hello.controller;

import com.example.hello.dto.ch63_User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ch63api/user2")
public class ApiController2 {
    @GetMapping("")
    public ch63_User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age){
        // required = false >> 파라미터 안들어와도 작동은하되, null로 됨
        ch63_User user = new ch63_User();
        user.setName(name);
        user.setAge(age);

        int a = 10+age;
        return user;
    }
    @PostMapping("")
    public ch63_User post(@Valid @RequestBody ch63_User user){
        System.out.println(user);
        return user;
    }

}
