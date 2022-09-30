package com.sgr.api.interfaces;

import java.util.List;

import com.sgr.entities.Persona;
import com.sgr.entities.PuntoDR;

public interface PuntoDRService {
	
	PuntoDR create(PuntoDR pdr);

	PuntoDR update(PuntoDR pdr);
	
	PuntoDR getById(long id);

	boolean delete(long id);
    
    List < PuntoDR > list();


}
