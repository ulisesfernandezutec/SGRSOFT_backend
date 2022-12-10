package com.sgr.api.interfaces.service;

import java.util.List;
import com.sgr.entities.PuntoRecoleccion;

public interface PuntoRecoleccionService {
	
	PuntoRecoleccion create(PuntoRecoleccion pdr);
	PuntoRecoleccion update(PuntoRecoleccion pdr);
	PuntoRecoleccion getById(long id);
	boolean delete(long id);
    List < PuntoRecoleccion > list();
	List < PuntoRecoleccion > findBetween(Long idIni, Long idFin);

}
