package com.spring.in.depth.mastering.bean.vehiclecheck;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LatestVehicleDamages {

    @JsonProperty("skeletonBodyDamages")
    private List<Object> skeletonBodyDamages = null;
    @JsonProperty("otherDamages")
    private List<Object> otherDamages = null;
    @JsonProperty("checkItemLatestStatuses")
    private List<Object> checkItemLatestStatuses = null;

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

    @JsonProperty("checkItemLatestStatuses")
    public List<Object> getCheckItemLatestStatuses() {
        return checkItemLatestStatuses;
    }

    @JsonProperty("checkItemLatestStatuses")
    public void setCheckItemLatestStatuses(List<Object> checkItemLatestStatuses) {
        this.checkItemLatestStatuses = checkItemLatestStatuses;
    }

}