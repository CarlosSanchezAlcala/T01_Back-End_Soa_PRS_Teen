package com.soa.canete.teen_soa_canete.repository;

import com.soa.canete.teen_soa_canete.domain.model.Teen;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TeenRepository extends ReactiveCrudRepository<Teen, Integer> {
}
