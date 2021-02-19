package com.spring.in.depth.mastering.customer;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.service.RequestApiService;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;


public class CustomerTest {

    @Autowired RequestApiService requestApiService;


    @Autowired
    JsonUtility jsonUtility;

    @Test
    @DisplayName("Create new customer with unique name and identity")
    public void createNewCustomer() {
        HttpHeaders httpHeaders =requestApiService.buildDefaultHeaders();
        HttpEntity<String> httpEntity = requestApiService.buildHttpEntity(PropManager.getInstance().getProperty(""),httpHeaders);
        ObjectNode authorizationResponse = requestApiService.requestPostAPI(PropManager.getInstance().getProperty("api.authentication"),httpEntity);
        httpEntity.getHeaders().set("Authorization","Bearer" + authorizationResponse.get("accessToken").textValue());



    }
}
