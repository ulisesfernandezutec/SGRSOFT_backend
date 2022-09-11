package com.sgr.api.interfaces;

import java.util.List;

import com.sgr.entities.Persona;
import com.sgr.entities.PuntoDR;
import com.sgr.entities.Rol;
import com.sgr.entities.TipoDeResiduo;
import com.sgr.entities.Usuario;

public interface UsuarioService {
	
	Usuario create(Usuario u);

	Usuario update(Usuario u);
	
	Usuario getById(long id);

	boolean delete(long id);
    
    List < Usuario > list();
}
