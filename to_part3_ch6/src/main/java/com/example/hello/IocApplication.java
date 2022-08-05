package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        // context로 bean가져오기
        // Encoder 생성자에 @Qualifier("base74Encoder") 지정했으므로 밑에꺼 따로 만들필요없음
        // Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);


        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //Encoder encoder = new Encoder(base64Encoder); // base64를 객체생성 내가하지않고 bean씀
        //Encoder encoder = context.getBean(Encoder.class);
        ch5_Encoder encoder = context.getBean("base64Encode", ch5_Encoder.class);
        String result = encoder.encode(url);
        System.out.println(result);

        encoder.setIEncoder(urlEncoder);
        result = encoder.encode(url);
        System.out.println(result);
    }
}

@Configuration // 한개의 클래스에 여러개의 빈을 등록할거야
class AppConfig{

    @Bean("base64Encode")
    public ch5_Encoder encoder(Base64Encoder base64Encoder){
        return new ch5_Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public ch5_Encoder encoder(UrlEncoder urlEncoder){
        return new ch5_Encoder(urlEncoder);
    }
}