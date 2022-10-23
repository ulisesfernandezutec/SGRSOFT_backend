package com.sgr.api.interfaces;

import java.util.List;

import com.sgr.entities.PuntoRecoleccion;

public interface PuntoDeRecoleccionService {
	
	PuntoRecoleccion create(PuntoRecoleccion pdr);

	PuntoRecoleccion update(PuntoRecoleccion pdr);
	
	PuntoRecoleccion getById(long id);

	boolean delete(long id);
    
    List < PuntoRecoleccion > list();

}
