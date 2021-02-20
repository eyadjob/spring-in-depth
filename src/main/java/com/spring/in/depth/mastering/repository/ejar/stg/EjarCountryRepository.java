package com.spring.in.depth.mastering.repository.ejar.stg;

import com.spring.in.depth.mastering.entity.ejar.stg.EjarCountryntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjarCountryRepository extends JpaRepository<EjarCountryntity, Long> {

    @Query(value = "SELECT id FROM CRM.Countries WHERE name LIKE '%:countryName%'", nativeQuery = true)
    List<EjarCountryntity> getCountryLikeName(@Param("countryName") String countryName);

    @Query(value = "SELECT id FROM CRM.Countries WHERE id = :countryId", nativeQuery = true)
    List<EjarCountryntity> getCountryById(@Param("countryId") int countryId);
}
