package com.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

/**
 * 环绕通知
 */
public class HijackAroundMethod implements MethodInterceptor{
    //切面，对目标方法进行增强
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("method name:"+methodInvocation.getMethod().getName());
        System.out.println("method arguments :"+
                Arrays.toString(methodInvocation.getArguments()));
        //前置通知
        System.out.println("HijackAroundMethod : Before method hijacked!");
        try {
            //proceed to original method call
            Object result = methodInvocation.proceed();
            //后置通知
            System.out.println("HijackAroundMethod : after method hijacked!");
            return result;
        } catch (IllegalArgumentException e) {
            //抛出异常通知
            System.out.println("HijackAroundMethod : Throw exception hijacked!");
            throw e;
        }
    }
}
