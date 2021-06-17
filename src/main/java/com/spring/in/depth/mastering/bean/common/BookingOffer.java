package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingOffer {

    @JsonProperty("offerId")
    private Integer offerId;
    @JsonProperty("isFullPaid")
    private Boolean isFullPaid;
    @JsonProperty("isCumulativeDiscountEnabled")
    private Object isCumulativeDiscountEnabled;

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
    public Object getIsCumulativeDiscountEnabled() {
        return isCumulativeDiscountEnabled;
    }

    @JsonProperty("isCumulativeDiscountEnabled")
    public void setIsCumulativeDiscountEnabled(Object isCumulativeDiscountEnabled) {
        this.isCumulativeDiscountEnabled = isCumulativeDiscountEnabled;
    }

}