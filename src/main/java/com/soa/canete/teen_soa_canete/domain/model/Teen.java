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
    private Integer id_adolescente;
    @Column
    private String name;
    @Column
    private String surnamefather;
    @Column
    private String surnamemother;
    @Column
    private String dni;
    @Column
    private String estado;

    public Teen(String name, String surnamefather, String surnamemother, String dni, String estado) {
        this.name = name;
        this.surnamefather = surnamefather;
        this.surnamemother = surnamemother;
        this.dni = dni;
        this.estado = estado;
    }
}
