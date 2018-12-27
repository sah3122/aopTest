package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class DemoAspect {
    @Before("execution(* com.example.demo.DemoMapper.*(..))")
    public void beforeDemo(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String methodName = joinPoint.toString().split(" ")[1];
        int len = methodName.split("\\.").length;
        String className = methodName.replace("."+methodName.split("\\.")[len-1], "");
        try{
            Class c = Class.forName(className);
            System.out.println(c.getName());
            System.out.println(c.getMethods());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("request : " + request.getRequestURI());
        System.out.println("Target : " + joinPoint.getTarget());
        System.out.println("Kind : " + joinPoint.getKind());
        System.out.println("ToLongString : " + joinPoint.toLongString());
        System.out.println("ToString : " + joinPoint.toString());
        System.out.println("Args : " + joinPoint.getArgs());
        System.out.println("Signature : " + joinPoint.getSignature());
        System.out.println("SourceLocation : " + joinPoint.getSourceLocation());
        System.out.println("StaticPart : " + joinPoint.getStaticPart());
    }
}
