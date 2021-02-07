package com.spring.in.depth.mastering.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


public class OutputService {
    @Value("${app.name}")
    private final String name;

    private TimeService timeService;
    private GreetingService greetingService;

    public OutputService(GreetingService greetingService, TimeService timeService) {
        this.timeService = timeService;
        this.greetingService = greetingService;

    }

    public String generateOutput() {
        return greetingService.greeting + " " + name;
    }

}
