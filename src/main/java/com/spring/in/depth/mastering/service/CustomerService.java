package com.spring.in.depth.mastering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    RequestApiService requestApiService;

    @Autowired
    EjarAuthenticationService authenticationService;

    @Autowired
    AllGetApiServices allGetApiServices;


    public CustomerService() {

    }


//

}
