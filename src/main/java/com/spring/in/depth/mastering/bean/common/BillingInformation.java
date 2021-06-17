package com.spring.in.depth.mastering.bean.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillingInformation {

    @JsonProperty("paid")
    private Double paid;
    @JsonProperty("totalDueAmount")
    private Double totalDueAmount;
    @JsonProperty("remaining")
    private Double remaining;

    @JsonProperty("paid")
    public Double getPaid() {
        return paid;
    }

    @JsonProperty("paid")
    public void setPaid(Double paid) {
        this.paid = paid;
    }

    @JsonProperty("totalDueAmount")
    public Double getTotalDueAmount() {
        return totalDueAmount;
    }

    @JsonProperty("totalDueAmount")
    public void setTotalDueAmount(Double totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }

    @JsonProperty("remaining")
    public Double getRemaining() {
        return remaining;
    }

    @JsonProperty("remaining")
    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }

}