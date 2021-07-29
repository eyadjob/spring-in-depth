package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class VehicleCheckPreparationDataResponse {

    @JsonProperty("result")
    public Result result;
    @JsonProperty("targetUrl")
    public Object targetUrl;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("error")
    public Object error;
    @JsonProperty("unAuthorizedRequest")
    public Boolean unAuthorizedRequest;
    @JsonProperty("__abp")
    public Boolean abp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public static class Result {

        @JsonProperty("countryId")
        public Integer countryId;
        @JsonProperty("fuelId")
        public Integer fuelId;
        @JsonProperty("odometer")
        public Object odometer;
        @JsonProperty("minimumOdomter")
        public Integer minimumOdomter;
        @JsonProperty("maximumOdomter")
        public Integer maximumOdomter;
        @JsonProperty("checkType")
        public CheckType checkType;
        @JsonProperty("checklistDetails")
        public List<ChecklistDetail> checklistDetails = null;
        @JsonProperty("latestVehicleCheckListStatus")
        public List<Object> latestVehicleCheckListStatus = null;
        @JsonProperty("vehicleSkeletonDetails")
        public VehicleSkeletonDetails vehicleSkeletonDetails;
        @JsonProperty("latestVehicleDamages")
        public LatestVehicleDamages latestVehicleDamages;
        @JsonProperty("skeletonBodiesWithTheirRepairTasks")
        public List<SkeletonBodiesWithTheirRepairTask> skeletonBodiesWithTheirRepairTasks = null;
        @JsonProperty("definedDamageTypes")
        public List<DefinedDamageType> definedDamageTypes = null;
        @JsonProperty("damageStatusId")
        public Object damageStatusId;
        @JsonProperty("vehicleSummary")
        public VehicleSummary vehicleSummary;
        @JsonProperty("lastECheckId")
        public Integer lastECheckId;
        @JsonProperty("disableDamageStatus")
        public Boolean disableDamageStatus;
        @JsonProperty("isTestingMode")
        public Boolean isTestingMode;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class DefinedDamageType {

            @JsonProperty("id")
            public Integer id;
            @JsonProperty("name")
            public String name;
            @JsonProperty("damageIcon")
            public String damageIcon;

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class VehicleSummary {

            @JsonProperty("statusId")
            public Integer statusId;
            @JsonProperty("plateNumber")
            public String plateNumber;
            @JsonProperty("category")
            public String category;
            @JsonProperty("model")
            public String model;
            @JsonProperty("manufactureYear")
            public Integer manufactureYear;

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class SkeletonBodiesWithTheirRepairTask {

            @JsonProperty("skeletonBodyId")
            public Integer skeletonBodyId;
            @JsonProperty("skeletonBodyColor")
            public Double skeletonBodyColor;
            @JsonProperty("damageId")
            public Integer damageId;
            @JsonProperty("imageUrl")
            public String imageUrl;
            @JsonProperty("damageName")
            public String damageName;
            @JsonProperty("repairTask")
            public RepairTask__1 repairTask;

            public static class RepairTask__1 {

                @JsonProperty("repairTaskId")
                public Integer repairTaskId;
                @JsonProperty("name")
                public String name;
                @JsonProperty("isRepeated")
                public Boolean isRepeated;
                @JsonProperty("cost")
                public Cost__1 cost;

                public static class Cost__1 {

                    @JsonProperty("value")
                    public Double value;
                    @JsonProperty("currencyId")
                    public Integer currencyId;

                }

            }

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class LatestVehicleDamages {

            @JsonProperty("skeletonBodyDamages")
            public List<Object> skeletonBodyDamages = null;
            @JsonProperty("otherDamages")
            public List<Object> otherDamages = null;
            @JsonProperty("checkItemLatestStatuses")
            public List<Object> checkItemLatestStatuses = null;

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class VehicleSkeletonDetails {

            @JsonProperty("id")
            public Integer id;
            @JsonProperty("name")
            public String name;
            @JsonProperty("image")
            public Image image;
            @JsonProperty("skeletonBase64string")
            public String skeletonBase64string;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class Image {

                @JsonProperty("id")
                public String id;
                @JsonProperty("url")
                public String url;
                @JsonProperty("isNewDocument")
                public Boolean isNewDocument;

            }

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class ChecklistDetail {

            @JsonProperty("id")
            public Integer id;
            @JsonProperty("name")
            public String name;
            @JsonProperty("checkItems")
            public List<CheckItem> checkItems = null;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class CheckItem {

                @JsonProperty("id")
                public Integer id;
                @JsonProperty("name")
                public String name;
                @JsonProperty("passedChoices")
                public List<Integer> passedChoices = null;
                @JsonProperty("choices")
                public List<Choice> choices = null;
                @JsonProperty("repairTasks")
                public List<RepairTask> repairTasks = null;

                @JsonInclude(JsonInclude.Include.NON_NULL)
                @Data
                public static class RepairTask {

                    @JsonProperty("id")
                    public Integer id;
                    @JsonProperty("name")
                    public String name;
                    @JsonProperty("isRepeated")
                    public Boolean isRepeated;
                    @JsonProperty("cost")
                    public Cost cost;

                    public static class Cost {

                        @JsonProperty("value")
                        public Double value;
                        @JsonProperty("currencyId")
                        public Integer currencyId;

                    }

                }
                @JsonInclude(JsonInclude.Include.NON_NULL)
                @Data
                public static class Choice {

                    @JsonProperty("id")
                    public Integer id;
                    @JsonProperty("name")
                    public String name;

                }

            }

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class CheckType {

            @JsonProperty("id")
            public Integer id;
            @JsonProperty("referenceTypeId")
            public Integer referenceTypeId;
            @JsonProperty("name")
            public String name;
            @JsonProperty("configurationDetails")
            public ConfigurationDetails configurationDetails;
            @JsonProperty("snapshotDetailsList")
            public List<SnapshotDetails> snapshotDetailsList = null;
            @JsonProperty("damageResponsibles")
            public List<DamageResponsible> damageResponsibles = null;
            @JsonProperty("damageStatuses")
            public List<Object> damageStatuses = null;
            @JsonProperty("notifiedEmailsUponDamage")
            public String notifiedEmailsUponDamage;
            @JsonProperty("directionId")
            public Integer directionId;

            public static class DamageResponsible {

                @JsonProperty("damageResponsibleName")
                public String damageResponsibleName;
                @JsonProperty("damageResponsibleId")
                public Integer damageResponsibleId;

            }

            public static class ConfigurationDetails {

                @JsonProperty("isKMRequired")
                public Boolean isKMRequired;
                @JsonProperty("isFuelRequired")
                public Boolean isFuelRequired;
                @JsonProperty("hasSignature")
                public Boolean hasSignature;
                @JsonProperty("allowRemoveDamage")
                public Boolean allowRemoveDamage;
                @JsonProperty("allowAddDamage")
                public Boolean allowAddDamage;

            }
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class SnapshotDetails {

                @JsonProperty("snapshotName")
                public String snapshotName;
                @JsonProperty("snapshotId")
                public Integer snapshotId;
                @JsonProperty("isRequired")
                public Boolean isRequired;
                @JsonProperty("snapshotMonth")
                public Integer snapshotMonth;
                @JsonProperty("snapshotYear")
                public Integer snapshotYear;
                @JsonProperty("image")
                public Object image;

            }


        }
    }
}