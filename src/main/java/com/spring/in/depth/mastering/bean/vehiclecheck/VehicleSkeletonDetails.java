package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleSkeletonDetails {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("skeletonBase64string")
    private String skeletonBase64string;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonProperty("skeletonBase64string")
    public String getSkeletonBase64string() {
        return skeletonBase64string;
    }

    @JsonProperty("skeletonBase64string")
    public void setSkeletonBase64string(String skeletonBase64string) {
        this.skeletonBase64string = skeletonBase64string;
    }

}