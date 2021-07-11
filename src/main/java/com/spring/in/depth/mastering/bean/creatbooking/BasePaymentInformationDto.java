package com.spring.in.depth.mastering.bean.creatbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BasePaymentInformationDto {

    @JsonProperty("discriminator")
    private String discriminator;
    @JsonProperty("paymentMethodId")
    private Integer paymentMethodId;
    @JsonProperty("amount")
    private Amount amount;

}