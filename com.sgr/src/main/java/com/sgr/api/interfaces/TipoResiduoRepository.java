package com.sgr.api.interfaces;

import java.util.Optional;

import com.sgr.entities.Persona;
import com.sgr.entities.TipoDeResiduo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipoResiduoRepository extends MongoRepository < TipoDeResiduo, Long > {
	
	

}
