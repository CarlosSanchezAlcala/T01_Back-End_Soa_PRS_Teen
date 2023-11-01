package com.soa.canete.teen_soa_canete.web;

import com.soa.canete.teen_soa_canete.domain.dto.TeenRequestDto;
import com.soa.canete.teen_soa_canete.domain.dto.TeenResponseDto;
import com.soa.canete.teen_soa_canete.service.TeenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/teenData")
@RequiredArgsConstructor
public class TeenController {

    final TeenService teenService;

    @GetMapping("/{id_adolescente}")
    public Mono<TeenResponseDto> getDataTeenById(@PathVariable Integer id_adolescente) {
        return this.teenService.findById(id_adolescente);
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

}
