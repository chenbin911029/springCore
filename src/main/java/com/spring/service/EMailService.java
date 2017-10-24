package com.spring.service;

import org.springframework.mail.MailSender;

public class EMailService {
    private MailSender mailSender;

    public void setMailSender(MailSender mailSender){
        this.mailSender = mailSender;
    }


}
