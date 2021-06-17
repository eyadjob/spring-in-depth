package com.spring.in.depth.mastering.bean.creatbooking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasePaymentInformationDto {

    @JsonProperty("discriminator")
    private String discriminator;
    @JsonProperty("paymentMethodId")
    private Integer paymentMethodId;
    @JsonProperty("amount")
    private Amount amount;

    @JsonProperty("discriminator")
    public String getDiscriminator() {
        return discriminator;
    }

    @JsonProperty("discriminator")
    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    @JsonProperty("paymentMethodId")
    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    @JsonProperty("paymentMethodId")
    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

}