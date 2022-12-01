package com.sgr.api.interfaces.service;

import java.util.List;

import com.sgr.entities.Vehiculo;

public interface VehiculoService {
	
	Vehiculo create(Vehiculo u);

	Vehiculo update(Vehiculo u);
	
	Vehiculo getById(Long id);

	boolean delete(Long id);
    
    List < Vehiculo > list();
}
