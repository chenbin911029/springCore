package com.spring.service.impl;

import com.spring.inter.Hello;
import org.springframework.stereotype.Service;

@Service
public class StrutsHelloWorld implements Hello {
    public void sayHello() {
        System.out.println("Struct Say Hello.");
    }
}
