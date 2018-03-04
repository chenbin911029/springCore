package com.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    /**
     * 定义一个方法，用于声明切入点表达式
     */
    @Pointcut("execution(* com.spring.inter.CustomerJ.addCustomer(..))")
    public void declareJointPointExpression(){};

    /**
     * 方法前
     * @param joinPoint
     */
    @Before("declareJointPointExpression()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    /**
     * 方法后
     * @param joinPoint
     */
    @After("execution(* com.spring.inter.CustomerJ.addCustomer(..)))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    /**
     * 方法返回第一个结果后
     * @param joinPoint
     * @param result
     */
    @AfterReturning(
            pointcut = "execution(* com.spring.inter.CustomerJ.addCustomerReturnValue(..))",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");
    }

    /**
     * 抛出异常后
     * @param joinPoint
     * @param error
     */
    @AfterThrowing(
            pointcut = "execution(* com.spring.inter.CustomerJ.addCustomerThrowException(..))",
            throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");

    }

    /**
     * 环绕通知，之前，之后，抛出异常后三者的结合
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution(* com.spring.inter.CustomerJ.addCustomerAround(..)))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("logAround() is running");
        System.out.println("hijacked method:"+joinPoint.getSignature().getName());
        System.out.println("hijacked arguments:" + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running.");
        joinPoint.proceed();//continue on the intercepted method
        System.out.println("Around after is running.");

        System.out.println("*******");
    }

}
