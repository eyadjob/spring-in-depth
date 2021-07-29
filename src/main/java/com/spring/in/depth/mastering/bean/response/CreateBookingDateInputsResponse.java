package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CreateBookingDateInputsResponse {
    @JsonProperty("result")
    public Result result;
    @JsonProperty("targetUrl")
    public Object targetUrl;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("error")
    public Object error;
    @JsonProperty("unAuthorizedRequest")
    public Boolean unAuthorizedRequest;
    @JsonProperty("__abp")
    public Boolean abp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static  class Result {

        @JsonProperty("nowDate")
        public String nowDate;
        @JsonProperty("minimumPickupDate")
        public String minimumPickupDate;
        @JsonProperty("minimumCorporatePickupDate")
        public String minimumCorporatePickupDate;
        @JsonProperty("maximumPickupDate")
        public String maximumPickupDate;
        @JsonProperty("countryIso")
        public String countryIso;

    }

}