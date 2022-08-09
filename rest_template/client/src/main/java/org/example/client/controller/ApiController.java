package org.example.client.controller;

import org.example.client.dto.Req2;
import org.example.client.dto.UserResponse;
import org.example.client.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ApiController {

    //Autowired는 옛날방식. 이젠 생성자주입방식
    private final RestTemplateService restTemplateService;

    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello")
    public Req2<UserResponse> get(){
        return restTemplateService.genericExchange();
    }




}
