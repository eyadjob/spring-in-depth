package com.spring.in.depth.mastering.entity.ejar.stg;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Countries")
@Data
public class EjarCountryntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
