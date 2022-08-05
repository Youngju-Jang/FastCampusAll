package com.example.hello.controller;

import com.example.hello.dto.ch63_User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/ch63api/user")
@Validated
public class ch65ApiController {
    @GetMapping("")
    public ch63_User get(
            @Size(min=2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age){
        ch63_User user = new ch63_User();
        user.setName(name);
        user.setAge(age);

        return user;
    }
    @PostMapping("")
    public ch63_User post(@Valid @RequestBody ch63_User user){
        System.out.println(user);
        return user;
    }

}
