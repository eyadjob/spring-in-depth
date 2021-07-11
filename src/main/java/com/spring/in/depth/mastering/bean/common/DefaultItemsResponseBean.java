package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DefaultItemsResponseBean {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("targetUrl")
    private Object targetUrl;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("error")
    private String error;
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


}
