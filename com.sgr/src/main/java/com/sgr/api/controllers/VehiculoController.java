package com.sgr.api.controllers;

import java.util.List;
import com.sgr.api.interfaces.impl.VehiculoServiceImplement;
import com.sgr.entities.dto.VehiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.Vehiculo;

@RestController
public class VehiculoController {

	@Autowired
	private VehiculoServiceImplement vehiculoServiceImplement;

	//getall
	@GetMapping("/vehiculo")
	public List<Vehiculo> getAll() {
			return vehiculoServiceImplement.list();
	}

	//getone
	@GetMapping("/vehiculo/{id}")
	public Vehiculo getvehiculo(@PathVariable Long id) {
		return vehiculoServiceImplement.getById(id);
	}

	//setone
	@PostMapping("/vehiculo/")
	public boolean setvehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
		Vehiculo vehiculo = new Vehiculo(vehiculoDTO.get_id(), vehiculoDTO.getNombre(), vehiculoDTO.getMatricula(), vehiculoDTO.getMarca(), vehiculoDTO.getModelo(), vehiculoDTO.getChofer());
		try {
			vehiculoServiceImplement.create(vehiculo);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PutMapping("/vehiculo/")
	public boolean updatevehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
		Vehiculo vehiculo = new Vehiculo(vehiculoDTO.get_id(), vehiculoDTO.getNombre(), vehiculoDTO.getMatricula(), vehiculoDTO.getMarca(), vehiculoDTO.getModelo(), vehiculoDTO.getChofer());
		try {
			if (vehiculoServiceImplement.getById(vehiculo.get_id()) != null) {
				vehiculoServiceImplement.update(vehiculo);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// delete
	@DeleteMapping("/vehiculo/{id}")
	public boolean deleteVehiculo(@PathVariable Long id) {
		try {
			vehiculoServiceImplement.delete(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
