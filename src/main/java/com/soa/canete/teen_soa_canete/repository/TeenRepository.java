package com.soa.canete.teen_soa_canete.repository;

import com.soa.canete.teen_soa_canete.domain.model.Teen;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TeenRepository extends ReactiveCrudRepository<Teen, Integer> {

    Mono<Teen> findByidentifier(UUID identifier);
}
