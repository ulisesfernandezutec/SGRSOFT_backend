package com.sgr.api;

import com.sgr.entities.Zona;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZonaRepository extends MongoRepository < Zona, Long > {
	
	

}
