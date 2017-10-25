package com.spring.controller;

import com.spring.service.EMailService;
import com.spring.service.EMailService3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenbin on 2017\10\24 0024.
 */
public class EmailController3 {
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-mail2.xml");

        EMailService3 eMail3 = (EMailService3) context.getBean("eMail3");

        eMail3.sendMail("lanlan",
                "金麟岂是池中物，一遇风云便化龙。倚楼听风雨，淡看江湖路。\n" +
                        "test spring email.\n" +
                        "祝您生活愉快！\n" +
                        "From 陈彬");

    }
}
