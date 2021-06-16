package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cost {

    @JsonProperty("value")
    private Double value;
    @JsonProperty("currencyId")
    private Integer currencyId;

    @JsonProperty("value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty("currencyId")
    public Integer getCurrencyId() {
        return currencyId;
    }

    @JsonProperty("currencyId")
    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

}