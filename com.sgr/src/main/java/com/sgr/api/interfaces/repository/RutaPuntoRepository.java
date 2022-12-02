package com.sgr.api.interfaces.repository;

import com.sgr.entities.RutaPunto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RutaPuntoRepository extends MongoRepository<RutaPunto, Long> {
}
