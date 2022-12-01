package com.sgr.api.interfaces.repository;

import com.sgr.entities.TipoDeResiduo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipoResiduoRepository extends MongoRepository < TipoDeResiduo, Long > {
	
	

}
