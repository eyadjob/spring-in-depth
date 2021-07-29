package com.spring.in.depth.mastering.repository.ejar.stg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EjarCommonRepositoryTest {


    public static void main(String[] args) {
        EjarCommonRepositoryTest test = new EjarCommonRepositoryTest();
        test.getVehicleInfoFormDB("i k d 1015","147");
    }


    private String getConnectionUrl() {

        return "jdbc:sqlserver://172.16.30.177;databaseName=eJarDbStaging";

    }


    private java.sql.Connection getConnection() {
        Connection con = null;
        try {

            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            System.out.println(getConnectionUrl());

            con = java.sql.DriverManager.getConnection(getConnectionUrl(), "ejar", "Wefaq@#1234");
            if (con != null) {
                System.out.println("Connection Successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
        }
        return con;
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement stmtSQL = getConnection().createStatement();
            resultSet = stmtSQL.executeQuery(query);
            resultSet.next();
            System.out.println(resultSet.getString("vehicleId"));
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
        return getRecordsFromDB(query,"vehicleId",  "modelId",  "year", "trimLevelId", "branchId", "plateNumber",  "rentalRateId", "categoryId" );
    }
}