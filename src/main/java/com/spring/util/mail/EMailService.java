package com.spring.util.mail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class EMailService {
    private JavaMailSenderImpl mailSender;

    public void setMailSender(JavaMailSenderImpl mailSender){
        this.mailSender = mailSender;
    }

    protected final static Logger LOG = LogManager.getLogger(EMailService.class);
    protected ApplicationContext applicationContext;
    /**
     * 发送邮件
     * @param from
     * @param to
     * @param subject
     * @param msg
     */
    public void sendMail(String from,String to,String subject,String msg){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);

        mailSender.send(message);
    }

    /**
     * 发送邮件。
     *
     * @param provider  邮件服务提供商名称。
     * @param from      发送方。
     * @param toES      收件方。
     * @param bccES     抄送方。
     * @param ccES      密送方。
     * @param subject   主题。
     * @param content   邮件内容。
     */
    public Map<String, Object> send(
            String provider,
            String from,
            String[] toES,
            String[] bccES,
            String[] ccES,
            String subject,
            String content) {

        Map<String, Object> result = new HashMap<String, Object>();
        if (toES == null || toES.length < 1) {
            result.put("sendResult", "false");
            result.put("sendReturn", "收件人不能为空。");
            return result;
        }

        if (subject == null || subject.trim().equals("")) {
            result.put("sendResult", "false");
            result.put("sendReturn", "邮件主题不能为空。");
            return result;
        }

        try {
            //JavaMailSenderImpl mailSender = getMailSender();
            MailSenderProvider mailSenderProvider = MailSenderProvider.create(provider);
            mailSender.setHost(mailSenderProvider.getHost());
            mailSender.setPort(mailSenderProvider.getPort());
            mailSender.setUsername(mailSenderProvider.getAccount());
            mailSender.setPassword(mailSenderProvider.getPassword());

            if (from == null) {
                from = mailSenderProvider.getAccount();
            }

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(toES);
            message.setSubject(subject);
            message.setSentDate(Calendar.getInstance().getTime());

            if (bccES != null && bccES.length > 0) {
                message.setBcc(bccES);
            }

            if (ccES != null && ccES.length > 0) {
                message.setCc(ccES);
            }

            message.setText(content);
            mailSender.send(message);

            result.put("sendResult", "success");
            result.put("sendReturn", "success");
        } catch (Exception ex) {
            LOG.error("发送邮件出现异常：" + ex.getMessage());
            result.put("sendResult", "false");
            result.put("sendReturn", "发送邮件出现异常：" + ex.getMessage());
        }

        return result;

    }

    /**
     * 利用Spring底层beanFactory接口基于原型(prototype)配置每次
     * 获取一个新的 JavaMailSenderImpl 实例
     * @return
     */
    protected JavaMailSenderImpl getMailSender() {
        return (JavaMailSenderImpl) applicationContext.getBean("mailSender");
    }
}
