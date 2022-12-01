package com.sgr.api.interfaces.service;

import java.util.List;

import com.sgr.entities.PuntoRecoleccionEstado;

public interface PuntoRecoleccionEstadoService {
	
	PuntoRecoleccionEstado create(PuntoRecoleccionEstado pdr);

	PuntoRecoleccionEstado update(PuntoRecoleccionEstado pdr);
	
	PuntoRecoleccionEstado getById(long id);

	boolean delete(long id);
    
    List < PuntoRecoleccionEstado > list();
    
}
