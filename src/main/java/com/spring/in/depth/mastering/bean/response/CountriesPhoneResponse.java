package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CountriesPhoneResponse {

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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class Result {

        @JsonProperty("items")
        private List<Item> items = null;

        @JsonProperty("items")
        public List<Item> getItems() {
            return items;
        }

        @JsonProperty("items")
        public void setItems(List<Item> items) {
            this.items = items;
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public class Item {

            @JsonProperty("name")
            private String name;
            @JsonProperty("phoneCode")
            private String phoneCode;
            @JsonProperty("flagUrl")
            private String flagUrl;
            @JsonProperty("flagId")
            private String flagId;
            @JsonProperty("id")
            private Integer id;

        }

    }

}
