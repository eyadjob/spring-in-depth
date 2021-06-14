package com.spring.in.depth.mastering.bean.countryinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.in.depth.mastering.bean.Branches;
import com.spring.in.depth.mastering.bean.DefaultItemsResponseBean;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrnecyInfo {

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

}