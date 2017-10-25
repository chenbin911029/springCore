package com.spring.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Administrator on 2017\10\25 0025.
 */
public class EMailService3 {
    private JavaMailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage){
        this.simpleMailMessage = simpleMailMessage;
    }
    public void setMailSender(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendMail(String dear,String content){
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(simpleMailMessage.getFrom());
            helper.setTo(simpleMailMessage.getTo());
            helper.setSubject(simpleMailMessage.getSubject());
            helper.setText(String.format(
                    simpleMailMessage.getText(),
                    dear,
                    content));
            FileSystemResource file =  new FileSystemResource(
                            "C:\\Users\\Administrator\\Desktop\\随记\\伴奏曲目.txt");
            helper.addAttachment(file.getFilename(),file);
        }catch (MessagingException e){
            throw new MailParseException(e);
        }

        mailSender.send(message);
    }
}
