package com.spring.util.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Administrator on 2017\10\25 0025.
 */
public class EMailService2 {
    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage){
        this.simpleMailMessage = simpleMailMessage;
    }
    public void setMailSender(MailSender mailSender){
        this.mailSender = mailSender;
    }
    public void sendMail(String dear,String content){
        SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
        message.setText(String.format(
                simpleMailMessage.getText(),
                dear,
                content));
        mailSender.send(message);
    }
}
