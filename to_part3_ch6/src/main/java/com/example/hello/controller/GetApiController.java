package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    //@RequestMapping("/hi") // get, post, put, delete 다 동작해버림
    @RequestMapping(path= "/hi", method= RequestMethod.GET) // get만 동작함 http://localhost:8080/api/get/hi
    public String hi(){
       return "hi";
    }

    //RequestMapping + RequestMethod.GET == GetMapping  <<<  <<<  <<<
    @GetMapping(path = "/hello") // http://localhost:8080/api/get/hello
    public String hello(){
        return "get Hello";
    }

    // http://localhost://8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    //public String pathVariable(@PathVariable String name){ // {}안의 이름과 같아야 함. 이름다르게 되야할경우?
    public String pathVariable(@PathVariable(name = "name") String pathName, String name){ // pathName에 name값이 들어가게 됨
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    // queryParam 받기 1번째
    //http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path ="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue()+ "\n") ;
        });
        return sb.toString();
    }

    // queryParam 받기 2번째
    // 명확하게 사용할 queryParam key가 정해져있는 경우엔?
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age ;
    }

    // queryParam 받기 3번째 : dto만들기 (제일 많이씀)
    // 알수없는 값(dto에 없는)이 들어올경우는 >> 그값은 매칭안됨
    @GetMapping("query-param03")  // @RequestParam 붙이지 않음
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString() ;
    }
}
