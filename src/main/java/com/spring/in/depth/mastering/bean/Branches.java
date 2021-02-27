package com.spring.in.depth.mastering.bean;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Branches {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("targetUrl")
    private Object targetUrl;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("error")
    private Object error;
    @JsonProperty("unAuthorizedRequest")
    private Boolean unAuthorizedRequest;
    @JsonProperty("__abp")
    private Boolean abp;

    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
    }

    @JsonProperty("targetUrl")
    public Object getTargetUrl() {
        return targetUrl;
    }

    @JsonProperty("targetUrl")
    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("error")
    public Object getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(Object error) {
        this.error = error;
    }

    @JsonProperty("unAuthorizedRequest")
    public Boolean getUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    @JsonProperty("unAuthorizedRequest")
    public void setUnAuthorizedRequest(Boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    @JsonProperty("__abp")
    public Boolean getAbp() {
        return abp;
    }

    @JsonProperty("__abp")
    public void setAbp(Boolean abp) {
        this.abp = abp;
    }

}