package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalDamagesCost {

    @JsonProperty("value")
    private Integer value;
    @JsonProperty("currencyId")
    private Integer currencyId;

    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Integer value) {
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