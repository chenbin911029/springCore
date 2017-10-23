package com.spring.controller;

import com.spring.service.OutputHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputHelperController {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "Spring-Common.xml");
        OutputHelper output = (OutputHelper) context.getBean("OutputHelper");
        output.generateOutput();
    }
}
