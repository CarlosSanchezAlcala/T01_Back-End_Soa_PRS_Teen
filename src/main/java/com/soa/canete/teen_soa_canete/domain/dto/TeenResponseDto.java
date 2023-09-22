package com.soa.canete.teen_soa_canete.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class TeenResponseDto  implements Serializable {
    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

    @Id
    private Integer id_adolescente;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String dni;
    @Column
    private String estado;
}
