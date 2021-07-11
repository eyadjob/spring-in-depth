package com.spring.in.depth.mastering.bean.vehiclecheck;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CheckType {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("referenceTypeId")
    private Integer referenceTypeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("configurationDetails")
    private ConfigurationDetails configurationDetails;
    @JsonProperty("snapshotDetailsList")
    private List<SnapshotDetails> snapshotDetailsList = null;
    @JsonProperty("damageResponsibles")
    private List<DamageResponsible> damageResponsibles = null;
    @JsonProperty("damageStatuses")
    private List<Object> damageStatuses = null;
    @JsonProperty("notifiedEmailsUponDamage")
    private String notifiedEmailsUponDamage;
    @JsonProperty("directionId")
    private Integer directionId;


}