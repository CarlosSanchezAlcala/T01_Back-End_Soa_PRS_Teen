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
    @Column
    private String crime_committed;
    @Column
    private String attorney;
    @Column
    private String codubi;
    @Column
    private String status;
}
