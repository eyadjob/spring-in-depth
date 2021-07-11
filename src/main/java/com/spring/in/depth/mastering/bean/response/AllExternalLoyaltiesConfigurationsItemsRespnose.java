package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

public class AllExternalLoyaltiesConfigurationsItemsRespnose {
    @JsonProperty("result")
    public Result result;
    @JsonProperty("targetUrl")
    public Object targetUrl;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("error")
    public String error;
    @JsonProperty("unAuthorizedRequest")
    public Boolean unAuthorizedRequest;
    @JsonProperty("__abp")
    public Boolean abp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class Item {

        @JsonProperty("id")
        public Integer id;
        @JsonProperty("number")
        public String number;
        @JsonProperty("displayText")
        public String displayText;
        @JsonProperty("isSelected")
        public Boolean isSelected;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class Result {

        @JsonProperty("items")
        public List<Item> items = null;

    }
}