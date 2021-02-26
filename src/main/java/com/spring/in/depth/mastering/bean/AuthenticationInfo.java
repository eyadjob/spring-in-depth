package com.spring.in.depth.mastering.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AuthenticationInfo {

    Map<String, String> userAccessTokens;

    public AuthenticationInfo() {
        this.userAccessTokens = new HashMap<>();
    }

}

