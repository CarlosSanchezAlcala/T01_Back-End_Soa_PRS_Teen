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
                dto.getUuid_teen(),
                dto.getName(),
                dto.getSurnameFather(),
                dto.getSurnameMother(),
                dto.getDni(),
                dto.getPhoneNumber(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getBirthade(),
                dto.getGender(),
                dto.getId_operativeunit(),
                dto.getCrimeCommitted(),
                dto.getId_attorney(),
                dto.getCodubi(),
                dto.getDate_hour_register(),
                dto.getStatus()
        );
    }

    public static Teen toModel(TeenRequestDto dto, Integer id_teen) {
        return new Teen(
                id_teen,
                dto.getUuid_teen(),
                dto.getName(),
                dto.getSurnameFather(),
                dto.getSurnameMother(),
                dto.getDni(),
                dto.getPhoneNumber(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getBirthade(),
                dto.getGender(),
                dto.getId_operativeunit(),
                dto.getCrimeCommitted(),
                dto.getId_attorney(),
                dto.getCodubi(),
                dto.getDate_hour_register(),
                dto.getStatus()
        );
    }

    public static TeenResponseDto toDto(Teen model) {
        return new TeenResponseDto(
                model.getId_teen(),
                model.getUuid_teen(),
                model.getName(),
                model.getSurnameFather(),
                model.getSurnameMother(),
                model.getDni(),
                model.getPhoneNumber(),
                model.getAddress(),
                model.getEmail(),
                model.getBirthade(),
                model.getGender(),
                model.getId_operativeunit(),
                model.getCrimeCommitted(),
                model.getId_attorney(),
                model.getCodubi(),
                model.getDate_hour_register(),
                model.getStatus()
        );
    }

}
