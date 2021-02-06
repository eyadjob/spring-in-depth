package com.spring.in.depth.mastering.config;

import com.spring.in.depth.mastering.service.GreetingService;
import com.spring.in.depth.mastering.service.OutputService;
import com.spring.in.depth.mastering.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.OutputStream;

@Configuration
@PropertySource("application.properties")
public class ApplicationConfig {
    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;


    private String greeting;

    private String name;

    public ApplicationConfig( @Value("${app.greeting}") String greeting, @Value("${app.name}") String name ) {
        this.greeting = greeting;
        this.name = name;
    }

    @Bean
    public TimeService timeService() {
        return new TimeService(true);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService, timeService,name);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(greeting);
    }
}
