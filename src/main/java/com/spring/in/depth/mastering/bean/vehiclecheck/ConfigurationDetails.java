package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
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

}