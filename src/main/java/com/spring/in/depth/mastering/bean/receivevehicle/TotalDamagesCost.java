package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TotalDamagesCost {

    @JsonProperty("value")
    private Integer value;
    @JsonProperty("currencyId")
    private Integer currencyId;

}