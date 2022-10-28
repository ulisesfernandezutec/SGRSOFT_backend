package com.sgr.api.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sgr.entities.PuntoRecoleccion;

public interface PuntoDeRecoleccionRepository extends MongoRepository < PuntoRecoleccion, Long > {
	

}
