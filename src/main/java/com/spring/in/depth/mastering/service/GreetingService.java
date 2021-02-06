package com.spring.in.depth.mastering.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Value("${app.greeting}") String greeting;

    public GreetingService() {
    }
}
