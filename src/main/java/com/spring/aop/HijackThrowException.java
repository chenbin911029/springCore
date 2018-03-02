package com.spring.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * 抛出异常通知
 * 实现ThrowsAdvice
 */
public class HijackThrowException implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable{
        System.out.println("HijackThrowException: Throw exception hi jacked.");
    }
}
