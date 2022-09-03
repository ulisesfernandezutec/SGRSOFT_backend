package com.sgr.api;

import java.util.Optional;

import com.sgr.entities.Vehiculo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculoRepository extends MongoRepository < Vehiculo, Long > {
	
	

}
