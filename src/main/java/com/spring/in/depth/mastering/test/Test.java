package com.spring.in.depth.mastering.test;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.spring.in.depth.mastering.service.AllGetApiServices;
import com.spring.in.depth.mastering.service.AllPostApiService;
import com.spring.in.depth.mastering.service.ApisData;
import com.spring.in.depth.mastering.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test {


    @Autowired
    AllPostApiService postApiService;

    @Autowired
    AllGetApiServices getApiServices;

    public void test(String countryName) {
        ApisData apisData = new ApisData();
        getApiServices.fillInitialData(apisData, countryName);
        postApiService.authenticateUser(apisData,"admin","ejarAdmin","123456");
//        postApiService.createNewCustomer(apisData);
        System.out.println("test");

    }
}
