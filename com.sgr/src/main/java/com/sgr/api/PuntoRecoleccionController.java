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

@RestController
public class PuntoRecoleccionController {

	@Autowired
	private PuntoRecoleccionServiceImplement puntoDRServiceImplement;

	// getall
	@GetMapping("/puntodr")
	public List<PuntoRecoleccion> getAll() {
		try {
			return puntoDRServiceImplement.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// getone
	@GetMapping("/puntodr/{id}")
	public PuntoRecoleccion getPersona(@PathVariable int id) {
		return puntoDRServiceImplement.getById(id);
	}

	//setone
	@PostMapping("/puntodr/")
	public boolean setPersona(@RequestBody PuntoRecoleccion puntoDr) {
		try {
			puntoDRServiceImplement.create(puntoDr);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// update
	@PutMapping("/puntodr/")
	public boolean updatePuntoR(@RequestBody PuntoRecoleccion puntoDr) {
		try {
			if (puntoDRServiceImplement.getById(puntoDr.get_id()) != null) {
				puntoDRServiceImplement.update(puntoDr);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// delete
	@DeleteMapping("/puntodr/{id}")
	public boolean deletePuntoR(@PathVariable Long id) {
		try {
			puntoDRServiceImplement.delete(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

}
