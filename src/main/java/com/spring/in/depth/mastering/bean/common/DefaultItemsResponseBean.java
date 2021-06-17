package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultItemsResponseBean {

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
    @JsonProperty("nowDate")
    private String nowDate;
    @JsonProperty("minimumPickupDate")
    private String minimumPickupDate;
    @JsonProperty("minimumCorporatePickupDate")
    private String minimumCorporatePickupDate;
    @JsonProperty("maximumPickupDate")
    private String maximumPickupDate;
    @JsonProperty("countryIso")
    private String countryIso;

    @JsonProperty("nowDate")
    public String getNowDate() {
        return nowDate;
    }

    @JsonProperty("nowDate")
    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }

    @JsonProperty("minimumPickupDate")
    public String getMinimumPickupDate() {
        return minimumPickupDate;
    }

    @JsonProperty("minimumPickupDate")
    public void setMinimumPickupDate(String minimumPickupDate) {
        this.minimumPickupDate = minimumPickupDate;
    }

    @JsonProperty("minimumCorporatePickupDate")
    public String getMinimumCorporatePickupDate() {
        return minimumCorporatePickupDate;
    }

    @JsonProperty("minimumCorporatePickupDate")
    public void setMinimumCorporatePickupDate(String minimumCorporatePickupDate) {
        this.minimumCorporatePickupDate = minimumCorporatePickupDate;
    }

    @JsonProperty("maximumPickupDate")
    public String getMaximumPickupDate() {
        return maximumPickupDate;
    }

    @JsonProperty("maximumPickupDate")
    public void setMaximumPickupDate(String maximumPickupDate) {
        this.maximumPickupDate = maximumPickupDate;
    }

    @JsonProperty("countryIso")
    public String getCountryIso() {
        return countryIso;
    }

    @JsonProperty("countryIso")
    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

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
