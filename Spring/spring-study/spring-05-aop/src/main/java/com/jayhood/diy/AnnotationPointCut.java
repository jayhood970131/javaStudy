package com.jayhood.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.jayhood.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("***********方法执行前************");
    }

    @After("execution(* com.jayhood.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("**********方法执行后**********");
    }

    @Around("execution(* com.jayhood.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint j) throws Throwable {
        System.out.println("环绕前");
        Signature signature = j.getSignature();
        System.out.println(signature);
        Object proceed = j.proceed();
        System.out.println(proceed);
        System.out.println("环绕后");
    }
}
