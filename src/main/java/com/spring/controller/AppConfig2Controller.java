//package com.spring.controller;
//
//import com.spring.config.AppConfig2;
//import com.spring.pojo.CustomerBo;
//import com.spring.pojo.SchedulerBo;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class AppConfig2Controller {
//    public static void main(String[] args){
//        ApplicationContext context = new AnnotationConfigApplicationContext(
//                AppConfig2.class);
//        CustomerBo customerBo = (CustomerBo) context.getBean("customerBo");
//        customerBo.printMsg("customerBo test");
//
//        SchedulerBo scheduler = (SchedulerBo) context.getBean("schedulerBo");
//        scheduler.printMsg("schedulerBo test");
//    }
//}
