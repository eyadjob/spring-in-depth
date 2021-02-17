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
import java.util.stream.Stream;

public class RequestAPIs {

    public static void main(String[] args) {
//      String e = "2021-02-17T13:02:06.8612824";
//       String e2 = "2021-02-17T13:16:22.451141";
//        System.out.println(e.length());
//        System.out.println(e.substring(0,e.length()-Math.abs(19-e.length())));
//        System.out.println(e2.substring(0,e2.length()-Math.abs(19-e2.length())));
        new RequestAPIs().requestPostAPI("test","tet");
    }


    public HttpEntity<String> buildDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        for(Map.Entry<String, Properties> p : PropManager.getInstance().getPropertiesValues().entrySet() ) {
            if ( p.getKey().contains("default.headers") ) {
                p.getValue().entrySet().forEach(prop -> headers.set((String) prop.getKey(), (String) prop.getValue()));
            }


//        for ( Map.Entry<String, String> prop : p.getValue().entrySet() )
//                {
////
//                }

        }


//        headers.set("Host", "ejar-st.alwefaq.com");
//        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.");
//        headers.set("Accept	", "application/json");
//        headers.set("Accept-Language", "en");
//        headers.set("Accept-Encoding", "gzip, deflate");
//        headers.set("Content-Type", "application/json");
//        headers.set("Pragma", "no-cache");
//        headers.set("Cache-Control", "no-cache");
//        headers.set("Expires", "Sat, 01 Jan 2000 00:00:00 GMT");
//        headers.set("X-Requested-With", "XMLHttpRequest");
//        headers.set(".AspNetCore.Culture", "en");
//        headers.set("Abp.TenantId", "1");
//        headers.set("Content-Length", "151");
//        headers.set("Origin", "http://172.16.30.17:5400");
//        headers.set("Connection", "keep-alive");
//        headers.set("Referer", "http://172.16.30.17:5400/account/login");
        String payload = PropManager.getInstance().getProperty("authenticate_post");
        Object jsonObject = new JsonUtility().getJsonFromString(payload);
        HttpEntity<String> entity = new HttpEntity<String>(payload, headers);
        return entity;

    }

    public ObjectNode requestPostAPI(String apiNameKey,String postBody) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(PropManager.getInstance().getLocatorName("env.url") + PropManager.getInstance().getProperty(apiNameKey), new RequestAPIs().buildDefaultHeaders(), String.class);
        ObjectNode objectNode = new JsonUtility().getObjectNodFromString(response.getBody());
        System.out.println("test");
        return objectNode;
    }

    public ObjectNode requestGetAPI(String apiNameKey,String... queryParams) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(PropManager.getInstance().getLocatorName("env.url") + PropManager.getInstance().getProperty(apiNameKey), new RequestAPIs().buildDefaultHeaders(), String.class);
        ObjectNode objectNode = new JsonUtility().getObjectNodFromString(response.getBody());
        System.out.println("test");
        return objectNode;
    }
}

//        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(payload);
//        Map<Object, Object> result = flattenJson.entrySet().stream().collect(Collectors.toMap(d -> d.getKey(), d -> d.getValue()));
