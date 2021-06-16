package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkeletonDetails {

    @JsonProperty("skeletonId")
    private Integer skeletonId;
    @JsonProperty("skeletonImage")
    private SkeletonImage skeletonImage;

    @JsonProperty("skeletonId")
    public Integer getSkeletonId() {
        return skeletonId;
    }

    @JsonProperty("skeletonId")
    public void setSkeletonId(Integer skeletonId) {
        this.skeletonId = skeletonId;
    }

    @JsonProperty("skeletonImage")
    public SkeletonImage getSkeletonImage() {
        return skeletonImage;
    }

    @JsonProperty("skeletonImage")
    public void setSkeletonImage(SkeletonImage skeletonImage) {
        this.skeletonImage = skeletonImage;
    }

}