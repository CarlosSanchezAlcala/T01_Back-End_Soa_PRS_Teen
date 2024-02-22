package com.soa.canete.teen_soa_canete.service.impl;

import com.soa.canete.teen_soa_canete.domain.dto.TeenRequestDto;
import com.soa.canete.teen_soa_canete.domain.dto.TeenResponseDto;
import com.soa.canete.teen_soa_canete.domain.mapper.TeenMapper;
import com.soa.canete.teen_soa_canete.domain.model.Teen;
import com.soa.canete.teen_soa_canete.exception.ResourceNotFoundException;
import com.soa.canete.teen_soa_canete.repository.TeenRepository;
import com.soa.canete.teen_soa_canete.service.TeenService;
import com.soa.canete.teen_soa_canete.util.TeenReportGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.UUID;

import static com.soa.canete.teen_soa_canete.domain.mapper.TeenMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeenImpl implements TeenService {

    final TeenRepository teenRepository;
    private TeenReportGenerator teenReportGenerator;

    @Autowired
    public TeenImpl(TeenRepository teenRepository, TeenReportGenerator teenReportGenerator) {
        this.teenRepository = teenRepository;
        this.teenReportGenerator = teenReportGenerator;
    }

    @Override
    public Mono<TeenResponseDto> findByIdTeen(Integer id_teen) {
        // Method by search teen by Id
        return this.teenRepository.findById(id_teen)
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> findTwoWayIdTeen(UUID uuid_teen) {
        return this.teenRepository.findByidentifier(uuid_teen)
                .map(TeenMapper::toDto);
    }

    @Override
    public Flux<TeenResponseDto> findAll() {
        return this.teenRepository.findAll()
                .sort(Comparator.comparing(Teen::getId_teen).reversed())
                .map(TeenMapper::toDto);
    }

    @Override
    public Flux<TeenResponseDto> findAllActive() {
        return this.teenRepository.findAll()
                .sort(Comparator.comparing(Teen::getId_teen).reversed())
                .filter((active) -> active.getStatus().equals("A"))
                .map(TeenMapper::toDto);
    }

    @Override
    public Flux<TeenResponseDto> findAllInactive() {
        return this.teenRepository.findAll()
                .sort(Comparator.comparing(Teen::getId_teen).reversed())
                .filter((inactive) -> inactive.getStatus().equals("I"))
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> saveNewTeen(TeenRequestDto request) {
        return this.teenRepository.save(toModel(request))
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> updateTeen(TeenRequestDto request, Integer id_teen) {
        return this.teenRepository.findById(id_teen)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador: " + id_teen + " no fue encontrado")))
                .flatMap((dataTeen) -> this.teenRepository.save(toModel(request, dataTeen.getId_teen())))
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> deleteLogicalTeen(Integer id_teen) {
        return this.teenRepository.findById(id_teen)
                .map((delete) -> {
                    delete.setStatus("I");
                    return delete;
                })
                .flatMap(teenRepository::save)
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> transferTeenToSoa(Integer id_teen) {
        return this.teenRepository.findById(id_teen)
                .map((transfer) -> {
                    transfer.setStatus("T");
                    return transfer;
                })
                .flatMap(teenRepository::save)
                .map(TeenMapper::toDto);
    }

    @Override
    public Mono<TeenResponseDto> reactiveLogicalTeen(Integer id_teen) {
        return this.teenRepository.findById(id_teen)
                .map((reactive) -> {
                    reactive.setStatus("A");
                    return reactive;
                })
                .flatMap(teenRepository::save)
                .map(TeenMapper::toDto);
    }
    @Override
    public Mono<Void> deleteLegalGuardian(Integer id_teen) {
        return this.teenRepository.deleteById(id_teen);
    }
    @Override
    public Mono<Mono<byte[]>> exportPdf() {
        return teenRepository.findAll()
                .collectList()
                .map(teenReportGenerator::exportToPdf);
    }
}
