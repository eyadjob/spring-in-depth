package com.spring.in.depth.mastering.service;

import org.springframework.stereotype.Service;


public class OutputService {
    private final String name;
    private TimeService timeService;
    private GreetingService greetingService;

    public OutputService(GreetingService greetingService, TimeService timeService,String name) {
        this.timeService = timeService;
        this.greetingService = greetingService;
        this.name = name;
    }

    public String generateOutput() {
        return greetingService.greeting + " " + name;
    }

}
