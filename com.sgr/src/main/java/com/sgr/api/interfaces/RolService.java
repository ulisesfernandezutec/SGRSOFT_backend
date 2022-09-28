package com.sgr.api.interfaces;

import java.util.List;

import com.sgr.entities.Persona;
import com.sgr.entities.PuntoDR;
import com.sgr.entities.Rol;

public interface RolService {
	
	Rol create(Rol rol);

	Rol update(Rol rol);
	
	Rol getById(long id);

	boolean delete(long id);
    
    List < Rol > list();


}
