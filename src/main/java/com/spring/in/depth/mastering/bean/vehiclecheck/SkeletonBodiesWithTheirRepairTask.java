package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkeletonBodiesWithTheirRepairTask {

    @JsonProperty("skeletonBodyId")
    private Integer skeletonBodyId;
    @JsonProperty("skeletonBodyColor")
    private Double skeletonBodyColor;
    @JsonProperty("damageId")
    private Integer damageId;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("damageName")
    private String damageName;
    @JsonProperty("repairTask")
    private RepairTask repairTask;

    @JsonProperty("skeletonBodyId")
    public Integer getSkeletonBodyId() {
        return skeletonBodyId;
    }

    @JsonProperty("skeletonBodyId")
    public void setSkeletonBodyId(Integer skeletonBodyId) {
        this.skeletonBodyId = skeletonBodyId;
    }

    @JsonProperty("skeletonBodyColor")
    public Double getSkeletonBodyColor() {
        return skeletonBodyColor;
    }

    @JsonProperty("skeletonBodyColor")
    public void setSkeletonBodyColor(Double skeletonBodyColor) {
        this.skeletonBodyColor = skeletonBodyColor;
    }

    @JsonProperty("damageId")
    public Integer getDamageId() {
        return damageId;
    }

    @JsonProperty("damageId")
    public void setDamageId(Integer damageId) {
        this.damageId = damageId;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("damageName")
    public String getDamageName() {
        return damageName;
    }

    @JsonProperty("damageName")
    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    @JsonProperty("repairTask")
    public RepairTask getRepairTask() {
        return repairTask;
    }

    @JsonProperty("repairTask")
    public void setRepairTask(RepairTask repairTask) {
        this.repairTask = repairTask;
    }

}