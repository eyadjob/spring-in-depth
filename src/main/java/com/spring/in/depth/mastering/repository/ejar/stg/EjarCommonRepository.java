package com.spring.in.depth.mastering.repository.ejar.stg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EjarCommonRepository {

    @Autowired
    @Qualifier("EjarStgDataSource")
    private DataSource ejarDataSource;

    public void executeQuery(String query) {


            JdbcTemplate jdbcTemplate = new JdbcTemplate(ejarDataSource);
            try {
                PreparedStatement ps = ejarDataSource.getConnection().prepareStatement(query) ;
                ResultSet rs = ps.executeQuery();
                System.out.println(rs.getString("id"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            jdbcTemplate.execute(query);
    }

    public String getCountryInfoBasedOnCountryName(String countryName) {
        String query = "SELECT * FROM CRM.Countries WHERE name LIKE '%" + countryName + "%'";
        executeQuery(query);
        return "test";
    }

}