package com.soa.canete.teen_soa_canete.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(name = "teen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teen {

    @Id
    private Integer id_teen;
    @Column
    private String name;
    @Column
    private String surnamefather;
    @Column
    private String surnamemother;
    @Column
    private String dni;
    @Column
    private String phonenumber;
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
    private String crime_committed;
    @Column("id_attorney")
    private Integer id_attorney;
    @Column
    private String codubi;
    @Column
    private String status;

    public Teen(String name, String surnamefather, String surnamemother, String dni, String phonenumber,
                String address, String email, LocalDate birthade, String gender, Integer id_operativeunit,
                String crime_committed, Integer id_attorney,String codubi,String status)
    {
        this.name = name;
        this.surnamefather = surnamefather;
        this.surnamemother = surnamemother;
        this.dni = dni;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.birthade = birthade;
        this.gender = gender;
        this.id_operativeunit = id_operativeunit;
        this.crime_committed = crime_committed;
        this.id_attorney = id_attorney;
        this.codubi = codubi;
        this.status = status;
    }
}
