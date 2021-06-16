package com.spring.in.depth.mastering.bean.vehiclecheck;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("referenceTypeId")
    public Integer getReferenceTypeId() {
        return referenceTypeId;
    }

    @JsonProperty("referenceTypeId")
    public void setReferenceTypeId(Integer referenceTypeId) {
        this.referenceTypeId = referenceTypeId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("configurationDetails")
    public ConfigurationDetails getConfigurationDetails() {
        return configurationDetails;
    }

    @JsonProperty("configurationDetails")
    public void setConfigurationDetails(ConfigurationDetails configurationDetails) {
        this.configurationDetails = configurationDetails;
    }

    @JsonProperty("snapshotDetailsList")
    public List<SnapshotDetails> getSnapshotDetailsList() {
        return snapshotDetailsList;
    }

    @JsonProperty("snapshotDetailsList")
    public void setSnapshotDetailsList(List<SnapshotDetails> snapshotDetailsList) {
        this.snapshotDetailsList = snapshotDetailsList;
    }

    @JsonProperty("damageResponsibles")
    public List<DamageResponsible> getDamageResponsibles() {
        return damageResponsibles;
    }

    @JsonProperty("damageResponsibles")
    public void setDamageResponsibles(List<DamageResponsible> damageResponsibles) {
        this.damageResponsibles = damageResponsibles;
    }

    @JsonProperty("damageStatuses")
    public List<Object> getDamageStatuses() {
        return damageStatuses;
    }

    @JsonProperty("damageStatuses")
    public void setDamageStatuses(List<Object> damageStatuses) {
        this.damageStatuses = damageStatuses;
    }

    @JsonProperty("notifiedEmailsUponDamage")
    public String getNotifiedEmailsUponDamage() {
        return notifiedEmailsUponDamage;
    }

    @JsonProperty("notifiedEmailsUponDamage")
    public void setNotifiedEmailsUponDamage(String notifiedEmailsUponDamage) {
        this.notifiedEmailsUponDamage = notifiedEmailsUponDamage;
    }

    @JsonProperty("directionId")
    public Integer getDirectionId() {
        return directionId;
    }

    @JsonProperty("directionId")
    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }


}