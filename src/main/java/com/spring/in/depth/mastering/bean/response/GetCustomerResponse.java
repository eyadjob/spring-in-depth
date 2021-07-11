package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GetCustomerResponse {

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

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("phone")
        private String phone;
        @JsonProperty("email")
        private String email;
        @JsonProperty("customerId")
        private Integer customerId;

    }

}