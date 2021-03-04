package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.bean.AuthenticationInfo;
import com.spring.in.depth.mastering.bean.CountryInfo;
import com.spring.in.depth.mastering.bean.CustomerInfo;
import com.spring.in.depth.mastering.bean.VehicleInfo;
import com.spring.in.depth.mastering.utility.PropManager;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Data
public class ApisData {

    private final Map<String, String> valuesCache;
    private final HttpHeaders defaultHeaders;
    private CountryInfo countryInfo;
    private VehicleInfo vehicleInfo;
    private CustomerInfo customerInfo;
    private AuthenticationInfo authenticationInfo;

    public ApisData() {
        this.valuesCache = new HashMap<>();
        this.defaultHeaders = buildDefaultHeaders();
        this.countryInfo = new CountryInfo();
        this.customerInfo = new CustomerInfo();
        this.authenticationInfo = new AuthenticationInfo();
        this.vehicleInfo = new VehicleInfo();
    }

    public HttpEntity<String> buildHttpEntity(String jsonPayload, HttpHeaders headers) {
        return new HttpEntity<>(jsonPayload, headers);
    }

    public HttpEntity<String> buildHttpEntity(String jsonPayload) {
        return new HttpEntity<>(jsonPayload, defaultHeaders);
    }


    public HttpEntity<String> buildHttpEntity(HttpHeaders headers) {
        return new HttpEntity<>(headers);
    }


    public HttpEntity<String> buildHttpEntity() {
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
