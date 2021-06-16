package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snapshot {

    @JsonProperty("snapshotId")
    private Integer snapshotId;
    @JsonProperty("snapshot")
    private Snapshot snapshot;

    @JsonProperty("snapshotId")
    public Integer getSnapshotId() {
        return snapshotId;
    }

    @JsonProperty("snapshotId")
    public void setSnapshotId(Integer snapshotId) {
        this.snapshotId = snapshotId;
    }

    @JsonProperty("snapshot")
    public Snapshot getSnapshot() {
        return snapshot;
    }

    @JsonProperty("snapshot")
    public void setSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

}