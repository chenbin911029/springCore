package com.spring.controller;

import com.spring.service.SpringHelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloWorldController {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("" +
                "spring-hello.xml");
        SpringHelloWorld obj = (SpringHelloWorld) context.getBean("helloBean");
        obj.printHello();
    }
}
