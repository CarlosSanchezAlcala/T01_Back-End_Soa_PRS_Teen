package com.soa.canete.teen_soa_canete.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "teen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teen {

    @Id
    private Integer id_teen;
    @Column("uuid_teen")
    private UUID identifier;
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
    private LocalDateTime date_hour_register;
    @Column
    private String status;

    public Teen(UUID identifier, String name, String surnameFather, String surnameMother, String dni, String phoneNumber,
                String address, String email, LocalDate birthade, String gender, Integer id_operativeunit,
                String crimeCommitted, Integer id_attorney, String codubi, LocalDateTime date_hour_register, String status) {
        this.identifier = identifier;
        this.name = name;
        this.surnameFather = surnameFather;
        this.surnameMother = surnameMother;
        this.dni = dni;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.birthade = birthade;
        this.gender = gender;
        this.id_operativeunit = id_operativeunit;
        this.crimeCommitted = crimeCommitted;
        this.id_attorney = id_attorney;
        this.codubi = codubi;
        this.date_hour_register = date_hour_register;
        this.status = status;
    }
}
