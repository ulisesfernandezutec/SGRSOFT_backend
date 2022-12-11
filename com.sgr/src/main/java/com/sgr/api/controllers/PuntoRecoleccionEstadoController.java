package com.sgr.api.controllers;

import java.util.List;

import com.sgr.api.interfaces.impl.PuntoRecoleccionEstadoServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.dto.PuntoRecoleccionEstadoDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.PuntoRecoleccionEstado;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
public class PuntoRecoleccionEstadoController {

	@Autowired
	private PuntoRecoleccionEstadoServiceImplement puntoRecoleccionEstadoServiceImplement;

	// getall
	@GetMapping("/pdre")
	public List<PuntoRecoleccionEstado> getAll() {
		try {
			return puntoRecoleccionEstadoServiceImplement.list();
		}catch (Exception e){
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+e.getMessage());
		}
	}

	// getone
	@GetMapping("/pdre/{id}")
	public PuntoRecoleccionEstado getPuntoRecoleccionEstado(@PathVariable int id) {
		try{
			return puntoRecoleccionEstadoServiceImplement.getById(id);
		}catch (Exception e){
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+e.getMessage());
		}
	}

	//setone
	@PostMapping("/pdre/")
	public boolean setPuntoRecoleccionEstado(@RequestBody PuntoRecoleccionEstadoDTO pdreDTO) {
		try {
			PuntoRecoleccionEstado pdre = new PuntoRecoleccionEstado(pdreDTO.get_id(), pdreDTO.getFecha(), pdreDTO.getUsuario(), pdreDTO.getEstado(), pdreDTO.getDetalle());
			puntoRecoleccionEstadoServiceImplement.create(pdre);
			return true;
		}catch (Exception e){
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR+e.getMessage());
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
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR+e.getMessage());
		}
	}

	// delete
	@DeleteMapping("/pdre/{id}")
	public boolean deletePuntoRecoleccion(@PathVariable Long id) {
		try {
			puntoRecoleccionEstadoServiceImplement.delete(id);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR+e.getMessage());
		}
	}

}
