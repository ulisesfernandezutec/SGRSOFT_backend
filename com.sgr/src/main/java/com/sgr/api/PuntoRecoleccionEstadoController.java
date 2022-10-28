package com.sgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.PuntoRecoleccion;
import com.sgr.entities.PuntoRecoleccionEstado;

@RestController
public class PuntoRecoleccionEstadoController {

	@Autowired
	private PuntoRecoleccionEstadoServiceImplement puntoRecoleccionEstadoServiceImplement;

	// getall
	@GetMapping("/pdre")
	public List<PuntoRecoleccionEstado> getAll() {
		try {
			return puntoRecoleccionEstadoServiceImplement.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// getone
	@GetMapping("/pdre/{id}")
	public PuntoRecoleccionEstado getPuntoRecoleccionEstado(@PathVariable int id) {
		return puntoRecoleccionEstadoServiceImplement.getById(id);
	}

	//setone
	@PostMapping("/pdre/")
	public boolean setPuntoRecoleccionEstado(@RequestBody PuntoRecoleccionEstado pdre) {
		try {
			puntoRecoleccionEstadoServiceImplement.create(pdre);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// update
	@PutMapping("/pdre/")
	public boolean updatePuntoRecoleccion(@RequestBody PuntoRecoleccionEstado pdre) {
		try {
			if (puntoRecoleccionEstadoServiceImplement.getById(pdre.get_id()) != null) {
				puntoRecoleccionEstadoServiceImplement.update(pdre);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// delete
	@DeleteMapping("/pdre/{id}")
	public boolean deletePuntoRecoleccion(@PathVariable Long id) {
		try {
			puntoRecoleccionEstadoServiceImplement.delete(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

}
