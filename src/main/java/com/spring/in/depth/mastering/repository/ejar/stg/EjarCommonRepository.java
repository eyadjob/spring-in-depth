package com.spring.in.depth.mastering.repository.ejar.stg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EjarCommonRepository {

    @Autowired
    @Qualifier("EjarStgDataSource")
    private DataSource ejarDataSource;

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement stmtSQL = ejarDataSource.getConnection().createStatement();
            resultSet = stmtSQL.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }


    public List<String> getRecordsFromDB(String query, String... columns) {
        ResultSet resultSet = executeQuery(query);
        List<String> result = new ArrayList<String>();
        try {
            while (resultSet.next()) {
                StringBuilder columnQuery = new StringBuilder();
                for (String s : columns) {
                    columnQuery.append(resultSet.getString(s) + ";");
                }
                result.add(columnQuery.toString());
            }
            return result;

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return result;
    }


    public String getCountryInfoBasedOnCountryName(String countryName) {
        String query = "SELECT * FROM CRM.Countries WHERE name LIKE '%" + countryName + "%'";
        executeQuery(query);
        return "test";
    }


    public List<String> getVehicleInfoFormDB(String plateNumber, String statusId) {
        String query = "SELECT  TOP(1) rv.id as vehicleId, rv.ModelId as modelId, rv.Year as year, rv.TrimLevelId as trimLevelId, rv.BranchId as branchId,rv.PlateNo  as plateNumber, rr.Id as rentalRateId, carModel.CarCategoryId as categoryId\n" +
                "FROM eJarDbStaging.rental.RentalVehicle as rv\n" +
                "JOIN  eJarDbStaging.[Rental].[RentalRates] as rr\n" +
                "ON rr.BranchId = rv.BranchId AND rr.ModelId = rv.ModelId OR ( rr.BranchId is NULL AND rr.ModelId = rv.ModelId AND isActive = 1 ) AND isActive = 1\n" +
                "JOIN  eJarDbStaging.[Rental].CarModels as carModel\n" +
                "ON carModel.ModelId = rv.ModelId\n" +
                "WHERE rv.plateNo LIKE '" + plateNumber + "'  AND rv.statusId='" + statusId + "' ORDER BY rr.Id DESC\n" +
                "\n";
        return getRecordsFromDB(query,"vehicleId",  "modelId",  "year", "trimLevelId", "branchId", "plateNumber",  "rentalRateId",  "categoryId" );
    }
}