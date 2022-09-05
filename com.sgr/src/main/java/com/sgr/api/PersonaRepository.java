package com.sgr.api;

import com.sgr.entities.Persona;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository < Persona, Long > {

	

}
