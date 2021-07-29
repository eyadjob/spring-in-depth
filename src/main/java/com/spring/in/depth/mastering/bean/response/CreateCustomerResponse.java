package com.spring.in.depth.mastering.bean.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResponse {

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
    public static  class Result {

        @JsonProperty("guid")
        public String guid;
        @JsonProperty("fullName")
        public FullName fullName;
        @JsonProperty("contactInformation")
        public ContactInformation contactInformation;
        @JsonProperty("basicInformation")
        public BasicInformation basicInformation;
        @JsonProperty("professionalInformation")
        public ProfessionalInformation professionalInformation;
        @JsonProperty("address")
        public Address address;
        @JsonProperty("secondaryAddress")
        public SecondaryAddress secondaryAddress;
        @JsonProperty("emergencyContacts")
        public List<Object> emergencyContacts = null;
        @JsonProperty("personalPhoto")
        public PersonalPhoto personalPhoto;
        @JsonProperty("documents")
        public List<Document> documents = null;
        @JsonProperty("externalLoyalties")
        public List<Object> externalLoyalties = null;
        @JsonProperty("isIntegrated")
        public Boolean isIntegrated;
        @JsonProperty("notes")
        public String notes;
        @JsonProperty("sourceId")
        public Integer sourceId;
        @JsonProperty("customerProvidersIntegrationResult")
        public CustomerProvidersIntegrationResult customerProvidersIntegrationResult;
        @JsonProperty("employeeId")
        public Object employeeId;
        @JsonProperty("liteCustomerId")
        public Integer liteCustomerId;
        @JsonProperty("registrationBranchId")
        public Integer registrationBranchId;
        @JsonProperty("isDeleted")
        public Boolean isDeleted;
        @JsonProperty("deleterUserId")
        public Object deleterUserId;
        @JsonProperty("deletionTime")
        public Object deletionTime;
        @JsonProperty("lastModificationTime")
        public Object lastModificationTime;
        @JsonProperty("lastModifierUserId")
        public Object lastModifierUserId;
        @JsonProperty("creationTime")
        public String creationTime;
        @JsonProperty("creatorUserId")
        public Integer creatorUserId;
        @JsonProperty("id")
        public Integer id;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class Address {

            @JsonProperty("countryId")
            public Integer countryId;
            @JsonProperty("cityId")
            public Object cityId;
            @JsonProperty("details")
            public String details;

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class BasicInformation {

            @JsonProperty("nationalityId")
            public Integer nationalityId;
            @JsonProperty("genderId")
            public Integer genderId;
            @JsonProperty("maritalStatusId")
            public Object maritalStatusId;
            @JsonProperty("noOfDependencies")
            public Object noOfDependencies;
            @JsonProperty("dateOfBirth")
            public String dateOfBirth;
            @JsonProperty("vipLevelId")
            public Object vipLevelId;

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class ContactInformation {

            @JsonProperty("primaryPhone")
            public String primaryPhone;
            @JsonProperty("secondaryPhone")
            public String secondaryPhone;
            @JsonProperty("email")
            public String email;
            @JsonProperty("isVerifiedEmail")
            public Boolean isVerifiedEmail;
            @JsonProperty("hasPermissionToSaveInvalidEmail")
            public Boolean hasPermissionToSaveInvalidEmail;

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class CustomerProvidersIntegrationResult {

            @JsonProperty("isUiFieldsDisabled")
            public Boolean isUiFieldsDisabled;
            @JsonProperty("isIntegrationSuccess")
            public Boolean isIntegrationSuccess;
            @JsonProperty("errorMessage")
            public Object errorMessage;
            @JsonProperty("canProceed")
            public Boolean canProceed;
            @JsonProperty("errorCode")
            public Object errorCode;

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class Document {

            @JsonProperty("issueCountryId")
            public Integer issueCountryId;
            @JsonProperty("typeId")
            public Integer typeId;
            @JsonProperty("number")
            public String number;
            @JsonProperty("copyNumber")
            public String copyNumber;
            @JsonProperty("issueDate")
            public String issueDate;
            @JsonProperty("expiryDate")
            public String expiryDate;
            @JsonProperty("discriminator")
            public String discriminator;
            @JsonProperty("typeName")
            public Object typeName;
            @JsonProperty("issueCountry")
            public Object issueCountry;
            @JsonProperty("attachment")
            public Attachment attachment;
            @JsonProperty("customerId")
            public Integer customerId;
            @JsonProperty("tenantId")
            public Integer tenantId;
            @JsonProperty("isDeleted")
            public Boolean isDeleted;
            @JsonProperty("deleterUserId")
            public Object deleterUserId;
            @JsonProperty("deletionTime")
            public Object deletionTime;
            @JsonProperty("lastModificationTime")
            public Object lastModificationTime;
            @JsonProperty("lastModifierUserId")
            public Object lastModifierUserId;
            @JsonProperty("creationTime")
            public String creationTime;
            @JsonProperty("creatorUserId")
            public Integer creatorUserId;
            @JsonProperty("id")
            public Integer id;
            @JsonProperty("licenseCategoryId")
            public Integer licenseCategoryId;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Data
            public static class Attachment {

                @JsonProperty("id")
                public Object id;
                @JsonProperty("url")
                public String url;
                @JsonProperty("size")
                public Double size;
                @JsonProperty("type")
                public String type;

            }


        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class FullName {

            @JsonProperty("first")
            public String first;
            @JsonProperty("second")
            public String second;
            @JsonProperty("third")
            public String third;
            @JsonProperty("fourth")
            public String fourth;
            @JsonProperty("family")
            public String family;
            @JsonProperty("displayName")
            public String displayName;

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class PersonalPhoto {

            @JsonProperty("id")
            public Object id;
            @JsonProperty("url")
            public String url;
            @JsonProperty("size")
            public Double size;
            @JsonProperty("type")
            public String type;

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public class ProfessionalInformation {

            @JsonProperty("organizationId")
            public Object organizationId;
            @JsonProperty("organizationName")
            public Object organizationName;
            @JsonProperty("occupationId")
            public Object occupationId;

        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Data
        public static class SecondaryAddress {

            @JsonProperty("countryId")
            public Object countryId;
            @JsonProperty("cityId")
            public Object cityId;
            @JsonProperty("details")
            public String details;

        }
    }

}