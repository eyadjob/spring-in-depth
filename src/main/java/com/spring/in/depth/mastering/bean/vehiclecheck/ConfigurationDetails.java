package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigurationDetails {

    @JsonProperty("isKMRequired")
    private Boolean isKMRequired;
    @JsonProperty("isFuelRequired")
    private Boolean isFuelRequired;
    @JsonProperty("hasSignature")
    private Boolean hasSignature;
    @JsonProperty("allowRemoveDamage")
    private Boolean allowRemoveDamage;
    @JsonProperty("allowAddDamage")
    private Boolean allowAddDamage;

    @JsonProperty("isKMRequired")
    public Boolean getIsKMRequired() {
        return isKMRequired;
    }

    @JsonProperty("isKMRequired")
    public void setIsKMRequired(Boolean isKMRequired) {
        this.isKMRequired = isKMRequired;
    }

    @JsonProperty("isFuelRequired")
    public Boolean getIsFuelRequired() {
        return isFuelRequired;
    }

    @JsonProperty("isFuelRequired")
    public void setIsFuelRequired(Boolean isFuelRequired) {
        this.isFuelRequired = isFuelRequired;
    }

    @JsonProperty("hasSignature")
    public Boolean getHasSignature() {
        return hasSignature;
    }

    @JsonProperty("hasSignature")
    public void setHasSignature(Boolean hasSignature) {
        this.hasSignature = hasSignature;
    }

    @JsonProperty("allowRemoveDamage")
    public Boolean getAllowRemoveDamage() {
        return allowRemoveDamage;
    }

    @JsonProperty("allowRemoveDamage")
    public void setAllowRemoveDamage(Boolean allowRemoveDamage) {
        this.allowRemoveDamage = allowRemoveDamage;
    }

    @JsonProperty("allowAddDamage")
    public Boolean getAllowAddDamage() {
        return allowAddDamage;
    }

    @JsonProperty("allowAddDamage")
    public void setAllowAddDamage(Boolean allowAddDamage) {
        this.allowAddDamage = allowAddDamage;
    }

}