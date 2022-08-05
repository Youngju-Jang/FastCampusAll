package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
		//String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

		// 외부에서 사용하는 객체를 주입받는 방식  = DI
		//Encoder encoder = new Encoder(new Base64Encoder());
		//ch5_Encoder encoder = new ch5_Encoder(new UrlEncoder());
		//String result = encoder.encode(url);

	}

}
