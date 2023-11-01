package com.soa.canete.teen_soa_canete.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TeenRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

    @Column
    private String name;
    @Column("surnamefather")
    private String surnameFather;
    @Column("surnamemother")
    private String surnameMother;
    @Column
    private String dni;
    @Column("phonenumber")
    private String phoneNumber;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private LocalDate birthade;
    @Column
    private String gender;
    @Column
    private Integer id_operativeunit;
    @Column("crime_committed")
    private String crimeCommitted;
    @Column
    private Integer id_attorney;
    @Column
    private String codubi;
    @Column
    private String status;
}
