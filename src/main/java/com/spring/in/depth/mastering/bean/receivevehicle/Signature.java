package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Signature {

    @JsonProperty("url")
    private String url;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}