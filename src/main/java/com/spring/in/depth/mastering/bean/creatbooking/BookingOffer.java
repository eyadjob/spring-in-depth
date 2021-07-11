package com.spring.in.depth.mastering.bean.creatbooking;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BookingOffer {

    @JsonProperty("offerId")
    private Integer offerId;
    @JsonProperty("isFullPaid")
    private Boolean isFullPaid;
    @JsonProperty("isCumulativeDiscountEnabled")
    private Boolean isCumulativeDiscountEnabled;


}