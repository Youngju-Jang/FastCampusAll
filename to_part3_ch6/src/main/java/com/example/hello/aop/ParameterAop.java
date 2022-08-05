package com.example.hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void cut(){}

    //@Before("cut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("method.getName : " + method.getName());

        Object[] args = joinPoint.getArgs(); //메소드에 들어가는 args배열

        for(Object obj : args){
            System.out.println("type : "+ obj.getClass().getSimpleName()); // (post >> )type : User3
            System.out.println("value : " + obj); // value : User3{id='hippo',~~
        }
    }

    //@AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
