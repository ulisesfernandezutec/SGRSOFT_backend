package com.sgr.api.interfaces.repository;

import com.sgr.entities.Ruta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RutaRepository extends MongoRepository<Ruta, Long> {
    List<Ruta> findBy_idBetween(long from, long to);
}
