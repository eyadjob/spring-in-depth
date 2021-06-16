package com.spring.in.depth.mastering.bean.vehiclecheck;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SnapshotDetails {

    @JsonProperty("snapshotName")
    private String snapshotName;
    @JsonProperty("snapshotId")
    private Integer snapshotId;
    @JsonProperty("isRequired")
    private Boolean isRequired;
    @JsonProperty("snapshotMonth")
    private Integer snapshotMonth;
    @JsonProperty("snapshotYear")
    private Integer snapshotYear;
    @JsonProperty("image")
    private Object image;

    @JsonProperty("snapshotName")
    public String getSnapshotName() {
        return snapshotName;
    }

    @JsonProperty("snapshotName")
    public void setSnapshotName(String snapshotName) {
        this.snapshotName = snapshotName;
    }

    @JsonProperty("snapshotId")
    public Integer getSnapshotId() {
        return snapshotId;
    }

    @JsonProperty("snapshotId")
    public void setSnapshotId(Integer snapshotId) {
        this.snapshotId = snapshotId;
    }

    @JsonProperty("isRequired")
    public Boolean getIsRequired() {
        return isRequired;
    }

    @JsonProperty("isRequired")
    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    @JsonProperty("snapshotMonth")
    public Integer getSnapshotMonth() {
        return snapshotMonth;
    }

    @JsonProperty("snapshotMonth")
    public void setSnapshotMonth(Integer snapshotMonth) {
        this.snapshotMonth = snapshotMonth;
    }

    @JsonProperty("snapshotYear")
    public Integer getSnapshotYear() {
        return snapshotYear;
    }

    @JsonProperty("snapshotYear")
    public void setSnapshotYear(Integer snapshotYear) {
        this.snapshotYear = snapshotYear;
    }

    @JsonProperty("image")
    public Object getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Object image) {
        this.image = image;
    }

}