package com.sgr.api.controllers;

import java.util.List;
import com.sgr.api.interfaces.impl.RolServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.dto.RolDTO;
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
import com.sgr.entities.Rol;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
public class RolController {

	@Autowired
	private RolServiceImplement rolserviceimplement;

	//getall
	@GetMapping("/rol")
	public List<Rol> getAll() {
		try {
			return rolserviceimplement.list();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + e.getMessage());
		}
	}
	//getone
	@GetMapping("/rol/{id}")
	public Rol getRol(@PathVariable Long id) {
		try{
			return rolserviceimplement.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + e.getMessage());
		}
	}
	//setone
	@PostMapping("/rol/")
	public String setRol(@RequestBody RolDTO rolDTO) {
		Rol rol = new Rol(rolDTO.get_id(), rolDTO.getNombre());
			try {
			rolserviceimplement.create(rol);
			return Messages.ROL_CREADO;
		} catch (Exception e) {
				log.error(e.getMessage());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR+ e.getMessage());
		}
	}
	@PutMapping("/rol/")
	public boolean updateRol(@RequestBody RolDTO rolDTO) {
		Rol rol = new Rol(rolDTO.get_id(), rolDTO.getNombre());
		try {
			if (rolserviceimplement.getById(rol.get_id()) != null) {
				rolserviceimplement.update(rol);
			}
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR+ e.getMessage());
		}
	}
	// delete
	@DeleteMapping("/rol/{id}")
	public String deleteRol(@PathVariable Long id) {
		try {
			rolserviceimplement.delete(id);
			return Messages.ROL_ELIMINADO;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR+ e.getMessage());
		}
	}
}
