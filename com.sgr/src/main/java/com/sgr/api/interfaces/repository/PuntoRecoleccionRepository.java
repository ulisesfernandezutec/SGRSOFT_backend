package com.sgr.api.interfaces.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sgr.entities.PuntoRecoleccion;

public interface PuntoRecoleccionRepository extends MongoRepository < PuntoRecoleccion, Long > {
	

}
