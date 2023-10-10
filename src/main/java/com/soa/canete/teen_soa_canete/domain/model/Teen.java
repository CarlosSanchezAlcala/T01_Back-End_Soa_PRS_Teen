package com.soa.canete.teen_soa_canete.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
    private String birthade;
    @Column
    private String gender;
    @Column
    private String crime_committed;
    @Column
    private String attorney;
    @Column
    private String status;

    public Teen(String name, String surnamefather, String surnamemother, String dni, String phonenumber,
                String address, String email, String birthade, String gender, String crime_committed,
                String attorney,String status)
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
        this.crime_committed = crime_committed;
        this.attorney = attorney;
        this.status = status;
    }
}
