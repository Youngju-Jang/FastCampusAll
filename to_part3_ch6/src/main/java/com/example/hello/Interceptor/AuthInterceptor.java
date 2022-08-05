package com.example.hello.Interceptor;

import com.example.hello.annotation.Auth;
import com.example.hello.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}", url);
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);

        // 나의 서버는 모두 public으로 동작
        // 단, Auth 권한가진 요청에 대해서는 세션, 쿠키,.. 을 보겠다
        if(hasAnnotation){            //권한체크

            String query = uri.getQuery();
            if(query.equals("name=steve")){
                return true;
            }
            throw new AuthException();
        }
        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz){

        // resource (javascript, html,..) 에대한 요청은 무조건 통과임.
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if((null != handlerMethod.getMethodAnnotation(clazz)) || (null != handlerMethod.getBeanType().getAnnotation(clazz))){
            // Auth annotation 있을때 true
            return true;
        }
        return false;
    }

}
