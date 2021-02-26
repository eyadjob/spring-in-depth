package com.spring.in.depth.mastering.controller;

import com.spring.in.depth.mastering.service.CustomerService;
import com.spring.in.depth.mastering.test.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/ApiTestAutomator")
public class TestController {

    @Autowired
    CustomerService customerService;

    @Autowired
    Test test;

    @RequestMapping(path = "/CreateCustomer/", method = RequestMethod.GET)
    public void getTest() {
    test.test("Saudi");


//        for (int i = 0; i < 10; i++) {
//            System.out.println("in thread number:" + i );
////         Runnable task = () -> {customerService.createNewCustomer();};
//            Thread thread1 = new Thread(new Runnable() {
//                @Override
//                public void run(){
//                    customerService.createNewCustomer();
//                }
//            });
//
//            thread1.start();
//        }
    }
}
