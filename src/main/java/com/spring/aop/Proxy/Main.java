package com.spring.aop.Proxy;

/**
 * Created by chenbin on 2018\3\4 0004.
 */
public class Main {
    public static void main(String[] args){
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        proxy.add(1,2);
    }

}
