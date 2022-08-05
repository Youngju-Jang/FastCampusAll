package com.example.hello.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@Component // spring에의해 bean으로 관리되도록
@WebFilter(urlPatterns = "/api/user/*")
@Slf4j
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
        //HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);


        // & 스프링이 모든걸 mapping한 다음에 읽어야 함
//        BufferedReader br = httpServletRequest.getReader();
//
//        br.lines().forEach(line -> {
//            log.info("url: {}, line : {}", url, line);
//        });


        // getReader() has already been called for this request 오류뜸 >>
        // 이미 br.lines로 request 다읽어버려서 커서가 제일뒤로 가버림
        // >> 컨트롤러에 json바디 전달을 못하게 됨
        // >> 해결위해 ContentCachingRequestWrapper 로 형변환

        // 기점
        chain.doFilter(httpServletRequest, httpServletResponse);

        String url = httpServletRequest.getRequestURI();

        // 후처리
        // req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());

        log.info("request url : {}, request body : {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();
        // getContentAsByteArray() 여기서 다 읽어버렸기땜에 커서가 끝에위치함 >> response body가 비어버림
        // >> 읽은내용만큼 다시복사필요
        httpServletResponse.copyBodyToResponse(); // > 이걸로 다시 body내용 채워넣음

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);


    }
}
