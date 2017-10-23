package com.spring.service;

import com.spring.inter.Hello;

public class HelloWorldService {
        private Hello helloWorld;

        public HelloWorldService() {

        }

        public void setHelloWorld(Hello helloWorld) {
            this.helloWorld = helloWorld;
        }

        public Hello getHelloWorld() {
            return this.helloWorld;
        }
}
