package com.sgr.api.interfaces.repository;

import com.sgr.entities.Vehiculo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculoRepository extends MongoRepository < Vehiculo, Long > {
	
	

}
