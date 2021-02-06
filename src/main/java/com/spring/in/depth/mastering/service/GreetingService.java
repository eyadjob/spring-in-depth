package com.spring.in.depth.mastering.service;

import org.springframework.stereotype.Service;


public class GreetingService {
    String greeting;

    public GreetingService(String greeting) {
    this.greeting = greeting;
    }
}
