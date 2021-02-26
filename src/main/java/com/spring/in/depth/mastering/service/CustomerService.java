package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.bean.CustomerInfo;
import com.spring.in.depth.mastering.utility.JsonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
