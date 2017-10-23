package com.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * spring aop 前置通知
 */

public class HijackBeforeMethod implements MethodBeforeAdvice{
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("HijackBeforeMethod:before method hi jacked.");
    }
}
