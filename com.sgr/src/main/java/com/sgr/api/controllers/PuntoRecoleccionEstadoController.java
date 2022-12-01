package com.sgr.api.controllers;

import java.util.List;

import com.sgr.api.interfaces.impl.PuntoRecoleccionEstadoServiceImplement;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.PuntoRecoleccionEstado;

@RestController
public class PuntoRecoleccionEstadoController {
	@Data
	public class PuntoRecoleccionEstadoDTO {

		private long _id;
		private String fecha;
		private long usuario;
		private String estado;
		private String detalle;

	}
	@Autowired
	private PuntoRecoleccionEstadoServiceImplement puntoRecoleccionEstadoServiceImplement;

	// getall
	@GetMapping("/pdre")
	public List<PuntoRecoleccionEstado> getAll() {
			return puntoRecoleccionEstadoServiceImplement.list();
	}

	// getone
	@GetMapping("/pdre/{id}")
	public PuntoRecoleccionEstado getPuntoRecoleccionEstado(@PathVariable int id) {
		return puntoRecoleccionEstadoServiceImplement.getById(id);
	}

	//setone
	@PostMapping("/pdre/")
	public boolean setPuntoRecoleccionEstado(@RequestBody PuntoRecoleccionEstadoDTO pdreDTO) {
		try {
			PuntoRecoleccionEstado pdre = new PuntoRecoleccionEstado(pdreDTO.get_id(), pdreDTO.getFecha(), pdreDTO.usuario, pdreDTO.getEstado(), pdreDTO.getDetalle());
			puntoRecoleccionEstadoServiceImplement.create(pdre);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// update
	@PutMapping("/pdre/")
	public boolean updatePuntoRecoleccion(@RequestBody PuntoRecoleccionEstadoDTO pdreDTO) {
		PuntoRecoleccionEstado pdre = new PuntoRecoleccionEstado(pdreDTO.get_id(), pdreDTO.getFecha(), pdreDTO.getUsuario(), pdreDTO.getEstado(), pdreDTO.getDetalle());
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
