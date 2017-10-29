package com.spring.controller;

import com.spring.util.mail.MailAttachment;
import com.spring.util.mail.MailTransmitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenbin on 2017\10\24 0024.
 */
public class EmailController {

    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-mail.xml");

        MailTransmitter mailTransmitter = (MailTransmitter) context.getBean("mailTransmitter");
       /* eMail.sendMail("13790432378@163.com",
                "591290365@qq.com",//591290365@qq.com 曹育健 ,1724002777@qq.com
                "来自陈彬的spring email",
                "金麟岂是池中物，一遇风云便化龙。倚楼听风雨，淡看江湖路。\n" +
                        "test spring email.\n" +
                        "祝您生活愉快！\n" +
                        "From 陈彬");*/
       try{
           /*
           Map<String,Object> result = mailTransmitter.sendSimpleTEXT(
                   "13790432378@163.com",
                   "13790432378@163.com",
                   "1724002777@qq.com",
                   "2017年10月27日邮件测试5",
                   "潮平两岸阔，风正一帆悬。");
           System.out.println(result.get("sendResult")+"   "+result.get("sendReturn"));
           */
           Map<String,Object> params = new HashMap<String,Object>();
           params.put("userName","懒懒");
           params.put("prizes","天马流星");
           params.put("honglingCapital","https://www.my089.com/");

           /*
           Map<String,Object> result2 = mailTransmitter.sendSimpleHTML(
                   "www.my089.com",
                   "13790432378@163.com",
                   "1724002777@qq.com",
                   "邮件模板测试2",
                   "",
                   "first_bind_mail",
                   params);
           System.out.println(result2.get("sendResult")+"   "+result2.get("sendReturn"));
           */

           MailAttachment[] atts = new MailAttachment[2];
           MailAttachment att1 = new MailAttachment();
           att1.setContentType("text/html");
           att1.setFileName("伴奏曲目");
           att1.setResource("E:\\test\\files\\伴奏曲目.txt");

           MailAttachment att2 = new MailAttachment();
           att2.setFileName("1688体验金");
           att2.setContentType("text/html");
           att2.setResource("E:\\test\\files\\TzctgBan1018.png");

           atts[0] = att1;
           atts[1] = att2;

           Map<String,Object> result3 = mailTransmitter.send(
                   "13790432378@163.com",
                   "13790432378@163.com",
                   new String[]{"1724002777@qq.com"},
                   null,
                   null,
                   "发送邮件带有附件",
                   "",
                   "first_bind_mail",
                   true,
                   atts,
                   params
                   );
           System.out.println(result3.get("sendResult")+"   "+result3.get("sendReturn"));
       }catch(Exception e){
           System.out.println("Exception throw:"+e.getMessage());
       }



    }
}
