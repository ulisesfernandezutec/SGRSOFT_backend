package com.sgr.api.interfaces;

import java.util.List;

import com.sgr.entities.TipoDeResiduo;

public interface TipoResiduoService {
	
	TipoDeResiduo create(TipoDeResiduo rol);

	TipoDeResiduo update(TipoDeResiduo rol);
	
	TipoDeResiduo getById(long id);

    TipoDeResiduo getById(Long id);

    boolean delete(long id);
    
    List < TipoDeResiduo > list();
}
