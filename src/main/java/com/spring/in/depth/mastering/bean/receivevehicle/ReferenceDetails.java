package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferenceDetails {

    @JsonProperty("checkTypeId")
    private Integer checkTypeId;

    @JsonProperty("checkTypeId")
    public Integer getCheckTypeId() {
        return checkTypeId;
    }

    @JsonProperty("checkTypeId")
    public void setCheckTypeId(Integer checkTypeId) {
        this.checkTypeId = checkTypeId;
    }

}