package com.sgr.api.controllers;

import java.util.List;

import com.sgr.api.interfaces.impl.PuntoRecoleccionServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.dto.FromToDTO;
import com.sgr.entities.dto.PuntoRecoleccionDTO;
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
import com.sgr.entities.PuntoRecoleccion;
import org.springframework.web.server.ResponseStatusException;
@Slf4j
@RestController
public class PuntoRecoleccionController {


	@Autowired
	private PuntoRecoleccionServiceImplement puntoDRServiceImplement;

	// getall
	@GetMapping("/puntodr")
	public List<PuntoRecoleccion> getAll() {
		try {
			return puntoDRServiceImplement.list();
		}catch (Exception e){
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+e.getMessage());
		}
	}

	// getbetwen
	@GetMapping("/puntodr/btw")
	public List<PuntoRecoleccion> getBetween(@RequestBody FromToDTO fromToDTO) {
		try {
			return puntoDRServiceImplement.findBetween(fromToDTO.getFrom(), fromToDTO.getTo());
		}catch (Exception e){
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+e.getMessage());
		}
	}

	// getone
	@GetMapping("/puntodr/{id}")
	public PuntoRecoleccion getPuntoDeRecolección(@PathVariable int id) {
		try{
			return puntoDRServiceImplement.getById(id);
		}catch (Exception e){
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR+e.getMessage());
		}
	}

	//setone
	@PostMapping("/puntodr/")
	public boolean setPuntoR(@RequestBody PuntoRecoleccionDTO puntoDr) {
		try {
			PuntoRecoleccion pdr = new PuntoRecoleccion(puntoDr.get_id(), puntoDr.getTipo(), puntoDr.getUsuario(), puntoDr.getLatitud(),puntoDr.getLongitud(),puntoDr.getDireccion(), puntoDr.getDescripcion(),puntoDr.getEstados());
			puntoDRServiceImplement.create(pdr);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR+e.getMessage());
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
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR+e.getMessage());
		}
	}

	// delete
	@DeleteMapping("/puntodr/{id}")
	public boolean deletePuntoR(@PathVariable Long id) {
		try {
			puntoDRServiceImplement.delete(id);
			return true;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR+e.getMessage());
		}
	}

}
