package com.spring.controller;

import com.spring.service.EMailService;
import com.spring.service.EMailService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenbin on 2017\10\24 0024.
 */
public class EmailController2 {
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-mail2.xml");

        EMailService2 eMail2 = (EMailService2) context.getBean("eMail2");
        eMail2.sendMail("陈彬","风积之厚，扶摇直上九万里。");
    }
}
