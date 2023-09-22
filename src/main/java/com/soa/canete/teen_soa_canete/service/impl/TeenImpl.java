package com.soa.canete.teen_soa_canete.service.impl;

import com.soa.canete.teen_soa_canete.domain.dto.TeenRequestDto;
import com.soa.canete.teen_soa_canete.domain.dto.TeenResponseDto;
import com.soa.canete.teen_soa_canete.domain.mapper.TeenMapper;
import com.soa.canete.teen_soa_canete.domain.model.Teen;
import com.soa.canete.teen_soa_canete.exception.ResourceNotFoundException;
import com.soa.canete.teen_soa_canete.repository.TeenRepository;
import com.soa.canete.teen_soa_canete.service.TeenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

import static com.soa.canete.teen_soa_canete.domain.mapper.TeenMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeenImpl implements TeenService {

    final TeenRepository teenRepository;

    @Override
    public Mono<TeenResponseDto> findById(Integer id_adolescente) {
        return this.teenRepository.findById(id_adolescente)
                .map(TeenMapper::toDto);
    }

    @Override
    public Flux<TeenResponseDto> findAll() {
        return this.teenRepository.findAll()
                .sort(Comparator.comparing(Teen::getId_adolescente).reversed())
                .map(TeenMapper::toDto);
    }

    @Override
    public Flux<TeenResponseDto> findAllActive() {
        return this.teenRepository.findAll()
                .sort(Comparator.comparing(Teen::getId_adolescente).reversed())
                .filter((active) -> active.getEstado().equals("A"))
                .map(TeenMapper::toDto);
    }

    @Override
    public Flux<TeenResponseDto> findAllInactive() {
        return this.teenRepository.findAll()
                .sort(Comparator.comparing(Teen::getId_adolescente).reversed())
                .filter((inactive) -> inactive.getEstado().equals("I"))
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> saveNewLegalGuardian(TeenRequestDto request) {
        return this.teenRepository.save(toModel(request))
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> updateLegalGuardian(TeenRequestDto request, Integer id_adolescente) {
        return this.teenRepository.findById(id_adolescente)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador: " + id_adolescente + " no fue encontrado")))
                .flatMap((dataTeen) -> this.teenRepository.save(toModel(request, dataTeen.getId_adolescente())))
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> deleteLogicalLegalGuardian(Integer id_adolescente) {
        return this.teenRepository.findById(id_adolescente)
                .map((delete) -> {
                    delete.setEstado("I");
                    return delete;
                })
                .flatMap(teenRepository::save)
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> reactiveLogicalLegalGuardian(Integer id_adolescente) {
        return this.teenRepository.findById(id_adolescente)
                .map((reactive) -> {
                    reactive.setEstado("A");
                    return reactive;
                })
                .flatMap(teenRepository::save)
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<Void> deleteLegalGuardian(Integer id_adolescente) {
        return this.teenRepository.deleteById(id_adolescente);
    }
}
