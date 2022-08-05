package com.example.hello.controller;

import com.example.hello.dto.ch6_User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/ch6api")
public class ch62_ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody ch6_User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field : " + field);
                // field : Field error in object 'ch6_User' on field 'phoneNumber': rejected value [01011112222]; co~~
                System.out.println("message : " + message);
                // message : 핸드폰 번호 양식과 맞지않습니다. 01x-xxx-xxxx

                sb.append("field : " + field.getField());
                sb.append("message : " + message);
                sb.append(System.lineSeparator());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        return ResponseEntity.ok(user);
    }
}
