package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    RequestApiService requestApiService;


    @Autowired
    JsonUtility jsonUtility;

//    @Test
//    @DisplayName("Create new customer with unique name and identity")
    public void createNewCustomer() {
        HttpHeaders httpHeaders = requestApiService.buildDefaultHeaders();
        HttpEntity<String> httpEntity = requestApiService.buildHttpEntity(PropManager.getInstance().getProperty("api.authenticate.post.payload"), httpHeaders);
        ObjectNode authorizationResponse = requestApiService.requestPostAPI("api.authentication", httpEntity);
        httpEntity.getHeaders().set("Authorization", "Bearer" + authorizationResponse.get("accessToken").textValue());
//        httpEntity.
        ObjectNode createCustomerResponse = requestApiService.requestPostAPI("api.create.customer", httpEntity);

    }
}
