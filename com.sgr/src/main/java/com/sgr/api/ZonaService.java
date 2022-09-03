package com.sgr.api;

import java.util.List;

import com.sgr.entities.Zona;

public interface ZonaService {
	
	Zona create(Zona u);

	Zona update(Zona u);
	
	Zona getById(long id);

	boolean delete(long id);
    
    List < Zona > list();
}
