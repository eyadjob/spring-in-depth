package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VehicleCheckDamages {

    @JsonProperty("checkItemStatuses")
    private List<CheckItemStatus> checkItemStatuses = null;
    @JsonProperty("skeletonBodyDamages")
    private List<Object> skeletonBodyDamages = null;
    @JsonProperty("otherDamages")
    private List<Object> otherDamages = null;

    @JsonProperty("checkItemStatuses")
    public List<CheckItemStatus> getCheckItemStatuses() {
        return checkItemStatuses;
    }

    @JsonProperty("checkItemStatuses")
    public void setCheckItemStatuses(List<CheckItemStatus> checkItemStatuses) {
        this.checkItemStatuses = checkItemStatuses;
    }

    @JsonProperty("skeletonBodyDamages")
    public List<Object> getSkeletonBodyDamages() {
        return skeletonBodyDamages;
    }

    @JsonProperty("skeletonBodyDamages")
    public void setSkeletonBodyDamages(List<Object> skeletonBodyDamages) {
        this.skeletonBodyDamages = skeletonBodyDamages;
    }

    @JsonProperty("otherDamages")
    public List<Object> getOtherDamages() {
        return otherDamages;
    }

    @JsonProperty("otherDamages")
    public void setOtherDamages(List<Object> otherDamages) {
        this.otherDamages = otherDamages;
    }

}