package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class RequestApiService {

    public Map<String, String> jsonNodesCache = new HashMap<>();

    private RequestApiService() {

    }


    public ResponseEntity<String> requestPostAPI(String apiNameKey, HttpEntity<String> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, String.class);
    }


    public ResponseEntity<String> requestGetAPI(String apiNameKey, String... queryParams) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        return restTemplate.getForEntity(uri, String.class);
    }
    public ResponseEntity<Object> requestGetAPI(Class className, String apiNameKey, String... queryParams) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        return  restTemplate.getForEntity(uri, className);
    }



    public String buildGetUri(String url, String... params) {
        StringBuilder getUri = new StringBuilder(url);
        for (int i = 0; i < params.length; i++) {
            if (i == 0)
                getUri.append("?").append(params[i]);
            else
                getUri.append("&").append(params[i]);
        }
        return getUri.toString();
    }
}

