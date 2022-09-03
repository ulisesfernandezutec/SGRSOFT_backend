package com.sgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.Vehiculo;

@RestController
public class VehiculoControllerw {

	@Autowired
	private VehiculoServiceImplement vehiculoServiceImplement;

	@GetMapping("/vehiculo")
	public List<Vehiculo> getAll() {
		try {
			return vehiculoServiceImplement.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/vehiculo/{id}")
	public Vehiculo getUsuario(@PathVariable int id) {
		return vehiculoServiceImplement.getById(id);
	}

	@PostMapping("/vehiculo/set/")
	public boolean setUsuario(@RequestBody Vehiculo vehiculo) {
		try {
			vehiculoServiceImplement.create(vehiculo);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PostMapping("/vehiculo/update/")
	public boolean updateRol(@RequestBody Vehiculo vehiculo) {
		try {
			if (vehiculoServiceImplement.getById(Long.parseLong(vehiculo.getId())) != null) {
				vehiculoServiceImplement.update(vehiculo);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
