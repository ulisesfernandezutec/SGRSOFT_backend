package com.sgr.api;

import java.util.List;

import com.sgr.entities.Persona;

public interface PersonaService {
	
	Persona create(Persona persona);

	Persona update(Persona persona);
	
	Persona getById(long id);

	boolean delete(long id);
    
    List < Persona > list();


}
