package com.spring.in.depth.mastering.pojo;

import com.spring.in.depth.mastering.bean.receivevehicle.ReceiveVehicle;
import com.spring.in.depth.mastering.bean.response.VehicleCheckPreparationDataResponse;
import com.spring.in.depth.mastering.service.ApisData;

import java.util.ArrayList;
import java.util.List;

public class ReceiveNewVehicleInfo {

    public ReceiveVehicle getReceiveNewVehicleInfo(ApisData apisData) {
        ReceiveVehicle receiveVehicle = new ReceiveVehicle();
        receiveVehicle.setVehicleId(apisData.getVehicleInfo().getId());
        receiveVehicle.setFuelId(apisData.getVehicleInfo().getFuelId());
        receiveVehicle.setOdometer(22);
        receiveVehicle.setSignature(new ReceiveVehicle.Signature());
        receiveVehicle.getSignature().setUrl(apisData.getUploadFileResponse().get(0).getResult().getVirtualPath());
        receiveVehicle.setReferenceDetails(new ReceiveVehicle.ReferenceDetails());
        receiveVehicle.getReferenceDetails().setCheckTypeId(6);
        receiveVehicle.setSkeletonDetails(new ReceiveVehicle.SkeletonDetails());
        receiveVehicle.getSkeletonDetails().setSkeletonImage(new ReceiveVehicle.SkeletonDetails.SkeletonImage());
        receiveVehicle.getSkeletonDetails().getSkeletonImage().setUrl(apisData.getVehicleCheckPreparationDataResponse().getResult().getVehicleSkeletonDetails().getImage().getUrl());
        receiveVehicle.getSkeletonDetails().getSkeletonImage().setId(apisData.getVehicleCheckPreparationDataResponse().getResult().getVehicleSkeletonDetails().getImage().getId());
        receiveVehicle.getSkeletonDetails().getSkeletonImage().setIsNewDocument(false);
        fillImagesForSnapShots(receiveVehicle, apisData);
        setVehicleCheckDamages(receiveVehicle,apisData);
        return receiveVehicle;

    }

    public void fillImagesForSnapShots(ReceiveVehicle receiveVehicle, ApisData apisData) {
        receiveVehicle.setSnapshots(new ArrayList<>(){{add(new ReceiveVehicle.Snapshot(5401,new ReceiveVehicle.Snapshot.Snapshot__1( new ReceiveVehicle.Snapshot.Snapshot__1.Image(apisData.getUploadFileResponse().get(1).getResult().getVirtualPath()))));}});
        receiveVehicle.setSnapshots(new ArrayList<>(){{add(new ReceiveVehicle.Snapshot(5400,new ReceiveVehicle.Snapshot.Snapshot__1( new ReceiveVehicle.Snapshot.Snapshot__1.Image(apisData.getUploadFileResponse().get(2).getResult().getVirtualPath()))));}});
    }


    public void setVehicleCheckDamages(ReceiveVehicle receiveVehicle, ApisData apisData) {
        List<ReceiveVehicle.VehicleCheckDamages.CheckItemStatus> damages = new ArrayList<>();
        for (VehicleCheckPreparationDataResponse.Result.ChecklistDetail v : apisData.getVehicleCheckPreparationDataResponse().getResult().getChecklistDetails()) {
            for (VehicleCheckPreparationDataResponse.Result.ChecklistDetail.CheckItem i : v.getCheckItems()) {
                damages.add(new ReceiveVehicle.VehicleCheckDamages.CheckItemStatus(v.getId(), i.getId(), i.getChoices().get(0).getId()));
            }
        }
        receiveVehicle.getVehicleCheckDamages().setCheckItemStatuses(damages);
    }
}




