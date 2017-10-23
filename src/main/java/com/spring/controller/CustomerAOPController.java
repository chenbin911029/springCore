package com.spring.controller;

import com.spring.service.CustomerAOPService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CustomerAOPController {
    protected final static Logger LOG = LogManager.getLogger(CustomerAOPController.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-module.xml");

        CustomerAOPService customerAOPService = (CustomerAOPService)context
                .getBean("customerAOPService");


        //System.out.println("pre customerAOPService");
        customerAOPService.printName();
        //System.out.println("in customerAOPService");
        customerAOPService.printURL();
        //System.out.println("after customerAOPService");
        try {
            customerAOPService.printThrowException();
        }catch (Exception e){
            //LOG.error(e);
            throw e;
        }
    }

}
