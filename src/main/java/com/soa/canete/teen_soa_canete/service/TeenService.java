package com.soa.canete.teen_soa_canete.service;

import com.soa.canete.teen_soa_canete.domain.dto.TeenRequestDto;
import com.soa.canete.teen_soa_canete.domain.dto.TeenResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface TeenService {

    Mono<TeenResponseDto> findById(Integer id_adolescente);
    Flux<TeenResponseDto> findAll();
    Flux<TeenResponseDto> findAllActive();
    Flux<TeenResponseDto> findAllInactive();
    Mono<TeenResponseDto> saveNewLegalGuardian(TeenRequestDto request);
    Mono<TeenResponseDto> updateLegalGuardian(TeenRequestDto request, Integer id_adolescente);
    Mono<TeenResponseDto> deleteLogicalLegalGuardian(Integer id_adolescente);
    Mono<TeenResponseDto> reactiveLogicalLegalGuardian(Integer id_adolescente);
    Mono<Void> deleteLegalGuardian(Integer id_adolescente);

}
