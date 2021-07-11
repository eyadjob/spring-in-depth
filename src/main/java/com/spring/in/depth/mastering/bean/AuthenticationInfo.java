package com.spring.in.depth.mastering.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AuthenticationInfo {

    Map<String, String> userAccessTokens;

    public AuthenticationInfo() {
        this.userAccessTokens = new HashMap<>();
    }

}

