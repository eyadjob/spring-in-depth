package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApisData {

    private final Map<String, String> valuesCache;
    private final HttpHeaders defaultHeaders;


    public ApisData() {
        this.valuesCache = new HashMap<>();
        this.defaultHeaders = buildDefaultHeaders();

    }

    public HttpEntity<String> buildHttpEntityWithPayload(String jsonPayload, HttpHeaders headers) {
        return new HttpEntity<>(jsonPayload, headers);
    }

    public HttpEntity<String> buildHttpEntityWithPayload(String jsonPayload) {
        return new HttpEntity<>(jsonPayload, defaultHeaders);
    }

    public HttpEntity<String> buildHttpEntityWithPayload(HttpHeaders headers) {
        return new HttpEntity<>(headers);
    }

    public HttpEntity<String> buildHttpEntityWithPayload() {
        return new HttpEntity<>(defaultHeaders);
    }

    public HttpHeaders getDefaultHeaders() {
        return defaultHeaders;
    }

    public Map<String, String> getValuesCache() {
        return valuesCache;
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
}
