package com.sgr.api.controllers;

import java.util.List;

import com.sgr.api.interfaces.impl.PuntoRecoleccionServiceImplement;
import com.sgr.entities.dto.FromToDTO;
import com.sgr.entities.dto.PuntoRecoleccionDTO;
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
			return puntoDRServiceImplement.list();
	}

	// getbetwen
	@GetMapping("/puntodr/btw")
	public List<PuntoRecoleccion> getBetween(@RequestBody FromToDTO fromToDTO) {
		return puntoDRServiceImplement.findBetween(fromToDTO.getFrom(),fromToDTO.getTo());
	}

	// getone
	@GetMapping("/puntodr/{id}")
	public PuntoRecoleccion getPersona(@PathVariable int id) {
		return puntoDRServiceImplement.getById(id);
	}

	//setone
	@PostMapping("/puntodr/")
	public boolean setPuntoR(@RequestBody PuntoRecoleccionDTO puntoDr) {
		try {
			PuntoRecoleccion pdr = new PuntoRecoleccion(puntoDr.get_id(), puntoDr.getTipo(), puntoDr.getUsuario(), puntoDr.getLatitud(),puntoDr.getLongitud(),puntoDr.getDireccion(), puntoDr.getDescripcion(),puntoDr.getEstados());
			puntoDRServiceImplement.create(pdr);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// update
	@PutMapping("/puntodr/")
	public boolean updatePuntoR(@RequestBody PuntoRecoleccionDTO puntoDr) {
		PuntoRecoleccion pdr = new PuntoRecoleccion(puntoDr.get_id(), puntoDr.getTipo(), puntoDr.getUsuario(), puntoDr.getLatitud(),puntoDr.getLongitud(),puntoDr.getDireccion(), puntoDr.getDescripcion(),puntoDr.getEstados());

		try {
			if (puntoDRServiceImplement.getById(pdr.get_id()) != null) {
				puntoDRServiceImplement.update(pdr);
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
