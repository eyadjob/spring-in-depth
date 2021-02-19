package com.spring.in.depth.mastering.controller;

import com.spring.in.depth.mastering.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/ApiTestAutomator")
public class TestController {

   @Autowired
    CustomerService customerService;

    @RequestMapping(path = "/CreateCustomer/", method = RequestMethod.GET)
    public void getTest( ) {
        customerService.createNewCustomer();
    }

}
