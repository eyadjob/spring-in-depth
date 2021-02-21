package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.utility.PropManager;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
@Data
public class ApisData {

    @Autowired
    RequestApiService requestApiService;

    private Map<String, String> valuesCache;
    private HttpHeaders defaultHeaders;

    public ApisData() {
        this.valuesCache = new HashMap<>();
        this.defaultHeaders = buildDefaultHeaders();
    }

    public HttpEntity<String> getHttpEntity(String jsonPayload, HttpHeaders headers) {
        return new HttpEntity<>(jsonPayload, headers);
    }

    public HttpEntity<String> getHttpEntity(String jsonPayload) {
        return new HttpEntity<>(jsonPayload, defaultHeaders);
    }

    public HttpEntity<String> getHttpEntity(HttpHeaders headers) {
        return new HttpEntity<>(headers);
    }

    public HttpEntity<String> getHttpEntity() {
        return new HttpEntity<>(defaultHeaders);
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
