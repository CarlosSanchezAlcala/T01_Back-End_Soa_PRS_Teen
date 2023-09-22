package com.soa.canete.teen_soa_canete.domain.mapper;

import com.soa.canete.teen_soa_canete.domain.dto.TeenRequestDto;
import com.soa.canete.teen_soa_canete.domain.dto.TeenResponseDto;
import com.soa.canete.teen_soa_canete.domain.model.Teen;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeenMapper {

    public static Teen toModel(TeenRequestDto dto) {
        return new Teen(
                dto.getName(),
                dto.getSurname(),
                dto.getDni(),
                dto.getEstado()
        );
    }

    public static Teen toModel(TeenRequestDto dto, Integer id_adolescente) {
        return new Teen(
                id_adolescente,
                dto.getName(),
                dto.getSurname(),
                dto.getDni(),
                dto.getEstado()
        );
    }

    public static TeenResponseDto toDto(Teen model) {
        return new TeenResponseDto(
                model.getId_adolescente(),
                model.getName(),
                model.getSurname(),
                model.getDni(),
                model.getEstado()
        );
    }

}
