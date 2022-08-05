package com.example.hello.controller;

import com.example.hello.dto.ch5_User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    //1. ResponseEntity
    //2. @ResponseBody  >> html파일 찾지않고responseBody만들어서 return함
    @ResponseBody
    @GetMapping("/user")
    public ch5_User user(){
        //UserDto user = new UserDto(); << 기존방식

        // var << 타입추론 가능한 단축어
        var user = new ch5_User();
        user.setName("hippo");
        user.setAddress("영주집");
        return user;
    }

}
