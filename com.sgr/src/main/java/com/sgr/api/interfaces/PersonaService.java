package com.sgr.api.interfaces;

import java.util.List;

import com.sgr.entities.Persona;

public interface PersonaService {
	
	Persona create(Persona persona);

	Persona update(Persona persona);
	
	Persona getById(Long id);

	boolean delete(Long id);
    
    List < Persona > list();

}
