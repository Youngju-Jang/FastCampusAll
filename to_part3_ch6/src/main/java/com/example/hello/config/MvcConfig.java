package com.example.hello.config;

import com.example.hello.Interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor // lombok >> authInterceptor을 매개변수로받는 생성자생성
public class MvcConfig implements WebMvcConfigurer {

    //@Autowired // << 순환참조 발생해버릴수있음. authInterceptor자신을 매칭..?
    //>> 이걸 막기위해 @RequiredArgsConstructor 이걸로 생성자에서 받음음
   private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
