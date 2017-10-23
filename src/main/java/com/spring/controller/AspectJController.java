package com.spring.controller;

import com.spring.inter.CustomerJ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJController {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-aspect.xml");

        CustomerJ customerJ = (CustomerJ) context.getBean("customerJ");
        customerJ.addCustomer();
        customerJ.addCustomerReturnValue();
        customerJ.addCustomerThrowException();
        customerJ.addCustomerAround("chenbin");
    }
}
