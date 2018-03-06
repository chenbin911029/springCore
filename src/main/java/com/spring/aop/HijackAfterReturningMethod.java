package com.spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置通知
 * 实现了AfterReturning
 */
public class HijackAfterReturningMethod implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("HijackAfterReturningMethod : after method hi jacked.");
    }
}
