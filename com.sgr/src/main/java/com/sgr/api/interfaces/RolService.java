package com.sgr.api.interfaces;

import java.util.List;
import com.sgr.entities.Rol;

public interface RolService {
	
	Rol create(Rol rol);

	Rol update(Rol persona);
	
	Rol getById(Long id);

	boolean delete(Long id);
    
    List < Rol > list();

}
