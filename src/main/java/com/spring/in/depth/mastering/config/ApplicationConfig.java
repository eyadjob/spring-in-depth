package com.spring.in.depth.mastering.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
@ComponentScan(basePackages = "com.spring.in.depth.mastering.service")
public class ApplicationConfig {

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