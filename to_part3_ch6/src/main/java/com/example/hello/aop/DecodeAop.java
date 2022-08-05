package com.example.hello.aop;

import com.example.hello.dto.ch5_User3;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void cut(){
    }

    @Pointcut("@annotation(com.example.hello.annotation.Decode)")
    private void enableDecode(){}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();
        for(Object arg : args){ // 받은 args 중에
            if(arg instanceof ch5_User3) { // User3객체가 있으면
                System.out.println("@@@@@@@@@@@@@@@@@@@@" + arg.getClass()); // class com.example.hello.dto.User3
                ch5_User3 user = ch5_User3.class.cast(arg); //형변환시키고
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                user.setEmail(email); //decoding된 이메일을 유저에게 다시 setting
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    // returning = "returnObj" >> 리턴오브젝트 이름설정하는거임
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        if(returnObj instanceof ch5_User3){
            ch5_User3 user = ch5_User3.class.cast(returnObj); //형변환시키고
            String email = user.getEmail();
            String base64Email= Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base64Email); //encoding된 이메일을 유저에게 다시 setting
        }
    }


}
