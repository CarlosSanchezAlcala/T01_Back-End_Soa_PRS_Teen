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
                dto.getSurnamefather(),
                dto.getSurnamemother(),
                dto.getDni(),
                dto.getPhonenumber(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getBirthade(),
                dto.getGender(),
                dto.getCrime_committed(),
                dto.getAttorney(),
                dto.getCodubi(),
                dto.getStatus()
        );
    }

    public static Teen toModel(TeenRequestDto dto, Integer id_teen) {
        return new Teen(
                id_teen,
                dto.getName(),
                dto.getSurnamefather(),
                dto.getSurnamemother(),
                dto.getDni(),
                dto.getPhonenumber(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getBirthade(),
                dto.getGender(),
                dto.getCrime_committed(),
                dto.getAttorney(),
                dto.getCodubi(),
                dto.getStatus()
        );
    }

    public static TeenResponseDto toDto(Teen model) {
        return new TeenResponseDto(
                model.getId_teen(),
                model.getName(),
                model.getSurnamefather(),
                model.getSurnamemother(),
                model.getDni(),
                model.getPhonenumber(),
                model.getAddress(),
                model.getEmail(),
                model.getBirthade(),
                model.getGender(),
                model.getCrime_committed(),
                model.getAttorney(),
                model.getCodubi(),
                model.getStatus()
        );
    }

}
