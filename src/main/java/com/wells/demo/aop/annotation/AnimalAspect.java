package com.wells.demo.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description 
 * Created by wells on 2020-07-22 09:53:31
 */

@Component
@Aspect
@Order(0)   // 为切面处理类增加顺序
public class AnimalAspect {
    @Pointcut(value = "execution(* com.wells.demo.aop.annotation.impl.AniamlServiceImpl.*(..))")
    public void point() {
    }

    @Before(value = "execution(* com.wells.demo.aop.annotation.impl.AniamlServiceImpl.*(..))")
    public void before() {
        System.out.println("before method");
    }

    @After(value = "execution(* com.wells.demo.aop.annotation.impl.AniamlServiceImpl.*(..))")
    public void after() {
        System.out.println("after method");
    }

    @Around(value = "point()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("around after");
        return result;
    }
}
