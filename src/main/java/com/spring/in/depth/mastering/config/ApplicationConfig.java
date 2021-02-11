package com.spring.in.depth.mastering.config;

import com.spring.in.depth.mastering.service.GreetingService;
import com.spring.in.depth.mastering.service.OutputService;
import com.spring.in.depth.mastering.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.io.OutputStream;

@Configuration
@PropertySource("application.properties")
public class ApplicationConfig {
    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;


    @Bean
    @Profile("!dev")
    public TimeService timeService() {
        return new TimeService(true);
    }

    @Bean
    @Profile("dev")
    public TimeService timeServiceDev() {
        return new TimeService(false);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService, timeService);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }
}


// beans scope :
// prototype :
    // new instance every time it is referenced
//session bean :
    /// only apply on web application
    // one instance per session
    // definition stored in the IOC not the instance, for garbage collection
// Request scope :
        // apply only on web application
        // one instance per request
        // definition stored in the IOC not the instance, for garbage collection


//Proxy :

        // add behavior to a class
        //private methods can't have proxies