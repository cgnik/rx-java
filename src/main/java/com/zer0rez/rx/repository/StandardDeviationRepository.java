package com.zer0rez.rx.repository;

import com.zer0rez.rx.domain.StandardDeviation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StandardDeviationRepository extends MongoRepository<StandardDeviation, String> {
}
