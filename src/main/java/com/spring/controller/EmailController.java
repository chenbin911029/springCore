package com.spring.controller;

import com.spring.service.EMailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenbin on 2017\10\24 0024.
 */
public class EmailController {
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-mail.xml");

        EMailService eMail = (EMailService) context.getBean("eMail");
        eMail.sendMail("13790432378@163.com",
                "591290365@qq.com",//591290365@qq.com 曹育健 ,1724002777@qq.com
                "来自陈彬的spring email",
                "金麟岂是池中物，一遇风云便化龙。倚楼听风雨，淡看江湖路。\n" +
                        "test spring email.\n" +
                        "祝您生活愉快！\n" +
                        "From 陈彬");

    }
}
