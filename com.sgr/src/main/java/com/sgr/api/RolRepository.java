package com.sgr.api;

import com.sgr.entities.Rol;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolRepository extends MongoRepository < Rol, Long > {
	
	

}
