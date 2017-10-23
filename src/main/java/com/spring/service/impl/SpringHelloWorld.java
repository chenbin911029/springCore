package com.spring.service.impl;

import com.spring.inter.Hello;
import org.springframework.stereotype.Service;

@Service
public class SpringHelloWorld implements Hello{
    public void sayHello() {
        System.out.println("spirng hello world.");
    }
}
