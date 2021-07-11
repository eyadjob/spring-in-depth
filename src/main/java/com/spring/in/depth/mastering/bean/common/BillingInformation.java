package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BillingInformation {

    @JsonProperty("paid")
    private Double paid;
    @JsonProperty("totalDueAmount")
    private Double totalDueAmount;
    @JsonProperty("remaining")
    private Double remaining;


}