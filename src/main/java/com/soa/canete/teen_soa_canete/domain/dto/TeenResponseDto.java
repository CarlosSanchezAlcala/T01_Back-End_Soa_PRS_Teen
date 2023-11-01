package com.soa.canete.teen_soa_canete.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TeenResponseDto  implements Serializable {

    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

    @Id
    private Integer id_teen;
    @Column
    private String name;
    @Column("surnamefather")            // Name in the DB PostgreSQL
    private String surnameFather;
    @Column("surnamemother")            // Name in the DB PostgreSQL
    private String surnameMother;
    @Column
    private String dni;
    @Column("phonenumber")              // Name in the DB PostgreSQL
    private String phoneNumber;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private LocalDate birthade;
    @Column
    private String gender;
    @Column("id_operativeunit")
    private Integer id_operativeunit;
    @Column
    private Integer id_operativeunit;
    @Column("crime_committed")          // Name in the DB PostgreSQL
    private String crimeCommitted;
    @Column
    private Integer id_attorney;
    @Column
    private String codubi;
    @Column
    private String status;
}
