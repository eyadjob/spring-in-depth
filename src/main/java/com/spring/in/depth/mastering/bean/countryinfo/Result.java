package com.spring.in.depth.mastering.bean.countryinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result {

    @JsonProperty("name")
    public String name;
    @JsonProperty("isoCode")
    public String isoCode;
    @JsonProperty("decimalPlaces")
    public Integer decimalPlaces;
    @JsonProperty("id")
    public Integer id;

}
