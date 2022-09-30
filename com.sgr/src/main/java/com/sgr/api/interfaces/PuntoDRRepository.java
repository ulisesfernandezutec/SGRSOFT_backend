package com.sgr.api.interfaces;

import java.util.Optional;

import com.sgr.entities.Persona;
import com.sgr.entities.PuntoDR;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PuntoDRRepository extends MongoRepository < PuntoDR, Long > {
	
	

}
