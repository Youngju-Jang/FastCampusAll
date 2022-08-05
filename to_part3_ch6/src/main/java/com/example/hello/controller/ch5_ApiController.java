package com.example.hello.controller;

import com.example.hello.dto.ch5_User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 해당 class : restApi 처리하는 controller로 등록됨
@RequestMapping("/ch5api") // URI을 지정해주는 annotation
public class ch5_ApiController {

    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;//이렇게하면 text형태로 감 >> 이렇겐 안씀
    }

    //JSON
    //req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public ch5_User json(@RequestBody ch5_User user){
        return user;
    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<ch5_User> put(@RequestBody ch5_User user){
        //ResponseEntity.ok(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(user); // 201 생성
    }

}
