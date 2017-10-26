package com.spring.controller;

import com.spring.util.mail.EMailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by chenbin on 2017\10\24 0024.
 */
public class EmailController {
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-mail.xml");

        EMailService eMail = (EMailService) context.getBean("eMail");
       /* eMail.sendMail("13790432378@163.com",
                "591290365@qq.com",//591290365@qq.com 曹育健 ,1724002777@qq.com
                "来自陈彬的spring email",
                "金麟岂是池中物，一遇风云便化龙。倚楼听风雨，淡看江湖路。\n" +
                        "test spring email.\n" +
                        "祝您生活愉快！\n" +
                        "From 陈彬");*/
        Map<String,Object> result = eMail.send("13790432378@163.com",
                "13790432378@163.com",
                new String[]{"1724002777@qq.com"},
                null,
                null,
                "2018年目标立flag",
                "穷且益坚，不坠青云之志。");
        System.out.println(result.get("sendResult")+"   "+result.get("sendReturn"));
    }
}
