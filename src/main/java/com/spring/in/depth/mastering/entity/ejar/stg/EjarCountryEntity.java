package com.spring.in.depth.mastering.entity.ejar.stg;

import com.spring.in.depth.mastering.utility.PropManager;
import com.spring.in.depth.mastering.utility.RegxUtility;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Countries")
@Data
public class EjarCountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = EjarColumnsName.ID)
    private int id;

    @Column(name = EjarColumnsName.Name)
    private String countryName;

    @Column(name = EjarColumnsName.CURRENCY_ID)
    private int currencyId;

    public String getCountryNameBasedOnLang() {
        return RegxUtility.getRegxMatch("\""+PropManager.getInstance().getProperty("execution.lang")+"\":\"(.*?)\"",1,countryName);
    }

}
