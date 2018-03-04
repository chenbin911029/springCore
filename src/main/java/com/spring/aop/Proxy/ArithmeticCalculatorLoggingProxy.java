package com.spring.aop.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by chenbin on 2018\3\4 0004.
 */
public class ArithmeticCalculatorLoggingProxy {
    //要代理的对象
    private ArithmeticCalculator target;
    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy(){
        ArithmeticCalculator proxy = null;
        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        //当调用代理对象其中的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy 正在返回的那个代理对象，一般情况下在invoke方法中不使用
             * @param method 正在被调用的方法
             * @param args 调用方法时，传入的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //
                System.out.println("The method "+methodName+"begin with "+ Arrays.asList(args));
                Object result = method.invoke(target,args);
                System.out.println("The method "+methodName+"end with "+ Arrays.asList(args));
                return result;
            }
        };

        proxy = (ArithmeticCalculator)Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
