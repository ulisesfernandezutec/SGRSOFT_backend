package com.sgr.api;

import java.util.List;

import com.sgr.entities.Persona;
import com.sgr.entities.PuntoDR;
import com.sgr.entities.Rol;
import com.sgr.entities.TipoDeResiduo;

public interface TipoResiduoService {
	
	TipoDeResiduo create(TipoDeResiduo rol);

	TipoDeResiduo update(TipoDeResiduo rol);
	
	TipoDeResiduo getById(long id);

	boolean delete(long id);
    
    List < TipoDeResiduo > list();
}
