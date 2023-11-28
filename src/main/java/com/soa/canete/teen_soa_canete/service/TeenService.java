package com.soa.canete.teen_soa_canete.service;

import com.soa.canete.teen_soa_canete.domain.dto.TeenRequestDto;
import com.soa.canete.teen_soa_canete.domain.dto.TeenResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface TeenService {

    Mono<TeenResponseDto> findById(Integer id_teen);

    Flux<TeenResponseDto> findAll();

    Flux<TeenResponseDto> findAllActive();

    Flux<TeenResponseDto> findAllInactive();

    Mono<TeenResponseDto> saveNewTeen(TeenRequestDto request);

    Mono<TeenResponseDto> updateTeen(TeenRequestDto request, Integer id_teen);

    Mono<TeenResponseDto> deleteLogicalTeen(Integer id_teen);

    Mono<TeenResponseDto> transferTeenToSoa(Integer id_teen);

    Mono<TeenResponseDto> reactiveLogicalTeen(Integer id_teen);

    Mono<Void> deleteLegalGuardian(Integer id_teen);

}
