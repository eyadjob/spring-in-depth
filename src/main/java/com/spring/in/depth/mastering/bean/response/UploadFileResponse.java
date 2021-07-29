package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UploadFileResponse {

    @JsonIgnore
    public String nameOfFile;
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
    public class Result {

        @JsonProperty("fileName")
        public String fileName;
        @JsonProperty("virtualPath")
        public String virtualPath;
        @JsonProperty("size")
        public Double size;

    }
}
