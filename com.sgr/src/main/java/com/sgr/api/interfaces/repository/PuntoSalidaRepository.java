package com.sgr.api.interfaces.repository;

import com.sgr.entities.PuntoSalida;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PuntoSalidaRepository extends MongoRepository<PuntoSalida, Long > {
}
