//package com.spring.controller;
//
//import com.spring.config.AppConfig;
//import com.spring.inter.Hello;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class AppController {
//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Hello hello = (Hello)context.getBean("helloBean");
//        hello.sayHello();
//    }
//}
