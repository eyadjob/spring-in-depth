package com.spring.in.depth.mastering.service;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.stream.Collectors;

public class RequestAPIs {

    public static void main(String[] args) {
        new RequestAPIs().requestAPI();
    }

    public HttpEntity<String> buildHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Host", "ejar-st.alwefaq.com");
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.");
//        headers.set("Accept	", "application/json");
//        headers.set("Accept-Language", "en");
//        headers.set("Accept-Encoding", "gzip, deflate");
        headers.set("Content-Type", "application/json");
//        headers.set("Pragma	no-cach", "no-cache");
//        headers.set("Cache-Control", "no-cache");
//        headers.set("Expires", "Sat, 01 Jan 2000 00:00:00 GMT");
//        headers.set("X-Requested-With", "XMLHttpRequest");
//        headers.set(".AspNetCore.Culture", "en");
//        headers.set("Abp.TenantId", "1");
//        headers.set("Content-Length", "151");
//        headers.set("Origin", "http://172.16.30.17:5400");
        headers.set("Connection", "keep-alive");
        headers.set("Referer", "http://172.16.30.17:5400/account/login");
        String payload = PropManager.getInstance().getProperty("authenticate_post");
        Object jsonObject = new JsonUtility().getJsonFromString(payload);
        HttpEntity<String> entity = new HttpEntity<String>(payload, headers);
        return entity;

    }

    public void requestAPI() {


        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<String> response = restTemplate.postForEntity("http://ejar-st.alwefaq.com:5400/api/TokenAuth/Authenticate", new RequestAPIs().buildHeaders(), String.class);

//        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(payload);
//        Map<Object, Object> result = flattenJson.entrySet().stream().collect(Collectors.toMap(d -> d.getKey(), d -> d.getValue()));
        System.out.println("test");

    }
}
