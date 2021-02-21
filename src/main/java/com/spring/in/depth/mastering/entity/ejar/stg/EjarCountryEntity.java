package com.spring.in.depth.mastering.entity.ejar.stg;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Countries")
@Data
public class EjarCountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = EjarColumnsName.ID)
    private Long id;

    @Column(name = EjarColumnsName.Name)
    private String countryName;

    @Column(name = EjarColumnsName.CURRENCY_ID)
    private int currencyId;

}
