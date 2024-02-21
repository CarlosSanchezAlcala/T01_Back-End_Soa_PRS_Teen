package com.soa.canete.teen_soa_canete.web;

import com.soa.canete.teen_soa_canete.domain.dto.TeenRequestDto;
import com.soa.canete.teen_soa_canete.domain.dto.TeenResponseDto;
import com.soa.canete.teen_soa_canete.service.TeenService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/teenData")
@RequiredArgsConstructor
public class TeenController {

    final TeenService teenService;

    @GetMapping("/listUnique/{id_teen}")
    public Mono<TeenResponseDto> getDataTeenForIdPrincipal(@PathVariable Integer id_teen) {
        return this.teenService.findByIdTeen(id_teen);
    }

    @GetMapping("/{uuid_teen}")
    public Mono<TeenResponseDto> getDataTeenById(@PathVariable UUID uuid_teen) {
        return this.teenService.findTwoWayIdTeen(uuid_teen);
    }

    @GetMapping("/listData")
    public Flux<TeenResponseDto> getDataCompleteTeen() {
        return this.teenService.findAll();
    }

    @GetMapping("/listData/active")
    public Flux<TeenResponseDto> getDataActiveTeen() {
        return this.teenService.findAllActive();
    }

    @GetMapping("/listData/inactive")
    public Flux<TeenResponseDto> getDataInactiveTeen() {
        return this.teenService.findAllInactive();
    }

    @PostMapping
    public Mono<TeenResponseDto> saveNewDataTeen(@RequestBody TeenRequestDto dto) {
        return this.teenService.saveNewTeen(dto);
    }

    @PutMapping("/{id_adolescente}")
    public Mono<TeenResponseDto> updateDataTeen(@RequestBody TeenRequestDto dto, @PathVariable Integer id_adolescente) {
        return this.teenService.updateTeen(dto, id_adolescente);
    }

    @PatchMapping("/deleteLogical/{id_adolescente}")
    public Mono<TeenResponseDto> deleteLogicalTeenData(@PathVariable Integer id_adolescente) {
        return this.teenService.deleteLogicalTeen(id_adolescente);
    }

    // Metodo para poder realizar la transferencia (Idea Principal e Inicial)
    @PatchMapping("/transferTeen/{id_adolescente}")
    public Mono<TeenResponseDto> transferTeenData(@PathVariable Integer id_adolescente) {
        return this.teenService.transferTeenToSoa(id_adolescente);
    }

    @PatchMapping("/reactiveLogical/{id_adolescente}")
    public Mono<TeenResponseDto> reactiveLogicalTeenData(@PathVariable Integer id_adolescente) {
        return this.teenService.reactiveLogicalTeen(id_adolescente);
    }

    @DeleteMapping("/{id_adolescente}")
    public Mono<Void> deleteCompleteTeen(@PathVariable Integer id_adolescente) {
        return this.teenService.deleteLegalGuardian(id_adolescente);
    }
    @GetMapping("/export-pdf")
    public Mono<ResponseEntity<byte[]>> exportPdf() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("Adolescentes", "Adolescentes.pdf");

        return teenService.exportPdf()
                .flatMap(pdfBytes -> pdfBytes)
                .map(pdfBytes -> ResponseEntity.ok().headers(headers).body(pdfBytes));
    }

}
