package com.spring.in.depth.mastering.bean.creatbooking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingOffer {

    @JsonProperty("offerId")
    private Integer offerId;
    @JsonProperty("isFullPaid")
    private Boolean isFullPaid;
    @JsonProperty("isCumulativeDiscountEnabled")
    private Boolean isCumulativeDiscountEnabled;

    @JsonProperty("offerId")
    public Integer getOfferId() {
        return offerId;
    }

    @JsonProperty("offerId")
    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    @JsonProperty("isFullPaid")
    public Boolean getIsFullPaid() {
        return isFullPaid;
    }

    @JsonProperty("isFullPaid")
    public void setIsFullPaid(Boolean isFullPaid) {
        this.isFullPaid = isFullPaid;
    }

    @JsonProperty("isCumulativeDiscountEnabled")
    public Boolean getIsCumulativeDiscountEnabled() {
        return isCumulativeDiscountEnabled;
    }

    @JsonProperty("isCumulativeDiscountEnabled")
    public void setIsCumulativeDiscountEnabled(Boolean isCumulativeDiscountEnabled) {
        this.isCumulativeDiscountEnabled = isCumulativeDiscountEnabled;
    }

}