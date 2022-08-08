package org.example.client.service;

import org.example.client.dto.UserRequest;
import org.example.client.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    // http://localhost:8080/api/server/hello 호출
    // response받을거
    public UserResponse hello(){

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "steve")
                .queryParam("age", 10)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        //String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse post(){
        //http:localhost:9090/api/server/user/{userId}/name/{userName}  >> 유저 등록시키기

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode() // url safe용
                .build()  // buildAndExpand도 있음
                .expand(100, "steve") // 순서대로 값 매칭시킴
                .toUri();
        System.out.println(uri);

        //http body -> object로 보낼거 -> object mapper가 알아서  json으로 바꿔
        // > rest template에서 > http body json으로 넣어줄거임
        UserRequest req = new UserRequest();
        req.setAge(10);
        req.setName("steve");

        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response = restTemplate.postForEntity(uri, req, String.class);
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);


        System.out.println(response.getStatusCode()); // 200 OK
        System.out.println(response.getHeaders());
        // [Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Mon, 08 Aug 2022 04:28:14 GMT",
        // Keep-Alive:"timeout=60", Connection:"keep-alive"]
        System.out.println(response.getBody()); // UserResponse{name='steve', age=10}

        return response.getBody();
    }
}


