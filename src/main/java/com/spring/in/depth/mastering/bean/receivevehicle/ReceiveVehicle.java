package com.spring.in.depth.mastering.bean.receivevehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ReceiveVehicle {

    @JsonProperty("vehicleId")
    private Integer vehicleId;
    @JsonProperty("fuelId")
    private Integer fuelId;
    @JsonProperty("odometer")
    private Integer odometer;
    @JsonProperty("signature")
    private Signature signature;
    @JsonProperty("referenceDetails")
    private ReferenceDetails referenceDetails;
    @JsonProperty("skeletonDetails")
    private SkeletonDetails skeletonDetails;
    @JsonProperty("vehicleCheckDamages")
    private VehicleCheckDamages vehicleCheckDamages;
    @JsonProperty("snapshots")
    private List<Snapshot> snapshots = null;
    @JsonProperty("totalDamagesCost")
    private TotalDamagesCost totalDamagesCost;
    @JsonProperty("damageStatusId")
    private Object damageStatusId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class VehicleCheckDamages {

        @JsonProperty("checkItemStatuses")
        public List<CheckItemStatus> checkItemStatuses = null;
        @JsonProperty("skeletonBodyDamages")
        public List<Object> skeletonBodyDamages = null;
        @JsonProperty("otherDamages")
        public List<Object> otherDamages = null;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class CheckItemStatus {

            @JsonProperty("checklistId")
            public Integer checklistId;
            @JsonProperty("checkItemId")
            public Integer checkItemId;
            @JsonProperty("choiceId")
            public Integer choiceId;

        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class TotalDamagesCost {

        @JsonProperty("value")
        public Integer value;
        @JsonProperty("currencyId")
        public Integer currencyId;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Snapshot {

        @JsonProperty("snapshotId")
        public Integer snapshotId;
        @JsonProperty("snapshot")
        public Snapshot__1 snapshot;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Snapshot__1 {

            @JsonProperty("image")
            public Image image;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Image {

                @JsonProperty("url")
                public String url;

            }

        }


    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class ReferenceDetails {

        @JsonProperty("checkTypeId")
        public Integer checkTypeId;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class Signature {

        @JsonProperty("url")
        public String url;

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class SkeletonDetails {

        @JsonProperty("skeletonId")
        public Integer skeletonId;
        @JsonProperty("skeletonImage")
        public SkeletonImage image;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class SkeletonImage {

            @JsonProperty("id")
            public String id;
            @JsonProperty("url")
            public String url;
            @JsonProperty("isNewDocument")
            public Boolean isNewDocument;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Image {

                @JsonProperty("url")
                public String url;

            }
        }
    }

}
