package com.sgr.api.interfaces.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sgr.entities.PuntoRecoleccion;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PuntoRecoleccionRepository extends MongoRepository < PuntoRecoleccion, Long > {

    List<PuntoRecoleccion> findBy_idBetween(long startId, long endId);

}
