package com.spring.controller;

import com.spring.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerController {
    public static void main( String[] args ) {
        //单例：spring IOC 容器每次返回同一个bean实例
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-module.xml");
        CustomerService custA = (CustomerService)context.getBean("customerService");
        custA.setMessage("Message by custA");
        System.out.println("Message : " + custA.getMessage());

        CustomerService custB = (CustomerService)context.getBean("customerService");
        System.out.println("Message : " + custB.getMessage());
    }

}
