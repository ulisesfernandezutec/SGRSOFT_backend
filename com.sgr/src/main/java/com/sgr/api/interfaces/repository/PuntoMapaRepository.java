package com.sgr.api.interfaces.repository;
import com.sgr.entities.PuntoMapa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PuntoMapaRepository extends MongoRepository<PuntoMapa, Long > {
}
