package com.spring.in.depth.mastering.bean.vehicle;

import com.spring.in.depth.mastering.bean.post.BookingCalculateBillingInformation;
import com.spring.in.depth.mastering.repository.ejar.stg.EjarCommonRepository;
import com.spring.in.depth.mastering.service.ApisData;
import com.spring.in.depth.mastering.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CalculateBillingInfo {

    @Autowired
    EjarCommonRepository ejarCommonRepository;

    public BookingCalculateBillingInformation getCreateBookingCalculateBillingInformationF(ApisData apisData,List<String> vehicleInfoFromDb) {

        BookingCalculateBillingInformation calculateBillingInformation = new BookingCalculateBillingInformation();
        calculateBillingInformation.setModelId(apisData.getVehicleCreate().getVehicleDtos().get(0).getVehicleManufacturingInfo().getModelId());
        calculateBillingInformation.setYear(apisData.getVehicleCreate().getVehicleDtos().get(0).getVehicleManufacturingInfo().getYear());
        calculateBillingInformation.setRentalRateId(Integer.parseInt(vehicleInfoFromDb.get(0).split(";")[6]));
        calculateBillingInformation.setDropoffDate(DateUtility.getDropDate(apisData.getCreateBookingDateInputsResponse().getResult().getMinimumPickupDate(), 1, 24));
        calculateBillingInformation.setPickupDate(DateUtility.getDropDate(apisData.getCreateBookingDateInputsResponse().getResult().getNowDate(), 0, 0));
        calculateBillingInformation.setStatusId(210);
        calculateBillingInformation.setVoucherOperationTypeId(2306);
        calculateBillingInformation.setPickupBranchId(Integer.parseInt(apisData.getVehicleCreate().getVehicleDtos().get(0).getBranchId()));
        calculateBillingInformation.setDropoffBranchId(Integer.parseInt(apisData.getVehicleCreate().getVehicleDtos().get(0).getBranchId()));
        calculateBillingInformation.setCustomerId(apisData.getCreateCustomerResponse().getResult().getLiteCustomerId());
        calculateBillingInformation.setCategoryId(vehicleInfoFromDb.get(0).split(";")[7]);
        return calculateBillingInformation;
    }
}
