package com.sgr.api.controllers;

import java.util.List;

import com.sgr.api.interfaces.impl.PuntoRecoleccionServiceImplement;
import com.sgr.entities.PuntoRecoleccionEstado;
import com.sgr.entities.TipoDeResiduo;
import lombok.Data;
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
	@Data
	public class PuntoRecoleccionDTO {
		private Long id;
		private TipoDeResiduo tipo;
		private Long usuario;
		private float latitud;
		private float longitud;
		private String direccion;
		private String descripcion;
		private List<PuntoRecoleccionEstado> estados;
	}
	@Autowired
	private PuntoRecoleccionServiceImplement puntoDRServiceImplement;

	// getall
	@GetMapping("/puntodr")
	public List<PuntoRecoleccion> getAll() {
			return puntoDRServiceImplement.list();
	}

	// getone
	@GetMapping("/puntodr/{id}")
	public PuntoRecoleccion getPersona(@PathVariable int id) {
		return puntoDRServiceImplement.getById(id);
	}

	//setone
	@PostMapping("/puntodr/")
	public boolean setPersona(@RequestBody PuntoRecoleccionDTO puntoDr) {
		try {
			PuntoRecoleccion pdr = new PuntoRecoleccion(puntoDr.getId(), puntoDr.getTipo(), puntoDr.getUsuario(), puntoDr.getLatitud(),puntoDr.getLongitud(),puntoDr.getDireccion(), puntoDr.getDescripcion(),puntoDr.getEstados());
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
		PuntoRecoleccion pdr = new PuntoRecoleccion(puntoDr.getId(), puntoDr.getTipo(), puntoDr.getUsuario(), puntoDr.getLatitud(),puntoDr.getLongitud(),puntoDr.getDireccion(), puntoDr.getDescripcion(),puntoDr.getEstados());

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
