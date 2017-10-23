package com.spring.controller;

import com.spring.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringELController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-module.xml");

        Student student = (Student) context.getBean("student");
        System.out.println(String.format("name:%s,id:%s",student.getName(),student.getId()));
        System.out.println(student);
    }
}
