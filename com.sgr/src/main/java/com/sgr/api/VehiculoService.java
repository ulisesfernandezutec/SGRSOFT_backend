package com.sgr.api;

import java.util.List;

import com.sgr.entities.Persona;
import com.sgr.entities.PuntoDR;
import com.sgr.entities.Rol;
import com.sgr.entities.TipoDeResiduo;
import com.sgr.entities.Usuario;
import com.sgr.entities.Vehiculo;

public interface VehiculoService {
	
	Vehiculo create(Vehiculo u);

	Vehiculo update(Vehiculo u);
	
	Vehiculo getById(long id);

	boolean delete(long id);
    
    List < Vehiculo > list();
}
