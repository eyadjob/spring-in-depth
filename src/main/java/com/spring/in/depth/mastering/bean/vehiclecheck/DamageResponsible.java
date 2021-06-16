package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DamageResponsible {

    @JsonProperty("damageResponsibleName")
    private String damageResponsibleName;
    @JsonProperty("damageResponsibleId")
    private Integer damageResponsibleId;

    @JsonProperty("damageResponsibleName")
    public String getDamageResponsibleName() {
        return damageResponsibleName;
    }

    @JsonProperty("damageResponsibleName")
    public void setDamageResponsibleName(String damageResponsibleName) {
        this.damageResponsibleName = damageResponsibleName;
    }

    @JsonProperty("damageResponsibleId")
    public Integer getDamageResponsibleId() {
        return damageResponsibleId;
    }

    @JsonProperty("damageResponsibleId")
    public void setDamageResponsibleId(Integer damageResponsibleId) {
        this.damageResponsibleId = damageResponsibleId;
    }

}