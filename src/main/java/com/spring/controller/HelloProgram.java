package com.spring.controller;

import com.spring.inter.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.service.HelloWorldService;

public class HelloProgram {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        HelloWorldService service =
                (HelloWorldService) context.getBean("helloWorldService");

        Hello hw= service.getHelloWorld();

        hw.sayHello();
    }
}
