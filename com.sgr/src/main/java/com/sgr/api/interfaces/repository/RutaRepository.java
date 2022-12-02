package com.sgr.api.interfaces.repository;

import com.sgr.entities.Ruta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RutaRepository extends MongoRepository<Ruta, Long> {
}
