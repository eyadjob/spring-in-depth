package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Properties;

public class RequestApiService {

    public static void main(String[] args) {
//      String e = "2021-02-17T13:02:06.8612824";
//       String e2 = "2021-02-17T13:16:22.451141";
//        System.out.println(e.length());
//        System.out.println(e.substring(0,e.length()-Math.abs(19-e.length())));
//        System.out.println(e2.substring(0,e2.length()-Math.abs(19-e2.length())));
//        new RequestApiService().requestPostAPI("test","tet");
    }


    public HttpHeaders buildDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        for (Map.Entry<String, Properties> p : PropManager.getInstance().getPropertiesValues().entrySet()) {
            if (p.getKey().contains("default.headers")) {
                p.getValue().entrySet().forEach(prop -> headers.set((String) prop.getKey(), (String) prop.getValue()));
            }
        }
        return headers;
    }

    public HttpEntity<String> buildHttpEntity(String jsonPayload, HttpHeaders headers) {
        String payload = PropManager.getInstance().getProperty("authenticate_post");
        Object jsonObject = new JsonUtility().getJsonFromString(payload);
        HttpEntity<String> entity = new HttpEntity<String>(jsonPayload, headers);
        return entity;

    }

    public ObjectNode requestPostAPI(String apiNameKey,HttpEntity<String> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(PropManager.getInstance().getLocatorName("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, String.class);
        ObjectNode objectNode = new JsonUtility().getObjectNodFromString(response.getBody());
        System.out.println("test");
        return objectNode;
    }

    public ObjectNode requestGetAPI(String apiNameKey,String... queryParams) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(PropManager.getInstance().getLocatorName("env.url") + PropManager.getInstance().getProperty(apiNameKey), new RequestApiService().buildDefaultHeaders(), String.class);
        ObjectNode objectNode = new JsonUtility().getObjectNodFromString(response.getBody());
        System.out.println("test");
        return objectNode;
    }
}

//        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(payload);
//        Map<Object, Object> result = flattenJson.entrySet().stream().collect(Collectors.toMap(d -> d.getKey(), d -> d.getValue()));
