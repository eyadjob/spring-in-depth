package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DamageResponsible {

    @JsonProperty("damageResponsibleName")
    private String damageResponsibleName;
    @JsonProperty("damageResponsibleId")
    private Integer damageResponsibleId;

}