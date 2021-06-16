package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("isNewDocument")
    private Boolean isNewDocument;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("isNewDocument")
    public Boolean getIsNewDocument() {
        return isNewDocument;
    }

    @JsonProperty("isNewDocument")
    public void setIsNewDocument(Boolean isNewDocument) {
        this.isNewDocument = isNewDocument;
    }

}