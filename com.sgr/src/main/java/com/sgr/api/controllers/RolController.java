package com.sgr.api.controllers;

import java.util.List;

import com.sgr.api.interfaces.impl.RolServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.dto.RolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.Rol;

@RestController
public class RolController {

	@Autowired
	private RolServiceImplement rolserviceimplement;

	//getall
	@GetMapping("/rol")
	public List<Rol> getAll() {
			return rolserviceimplement.list();
	}
	//getone
	@GetMapping("/rol/{id}")
	public Rol getRol(@PathVariable Long id) {
		return rolserviceimplement.getById(id);
	}

	//setone
	@PostMapping("/rol/")
	public String setRol(@RequestBody RolDTO rolDTO) {
		Rol rol = new Rol(rolDTO.get_id(), rolDTO.getNombre());
			try {
			rolserviceimplement.create(rol);
			return Messages.ROL_CREADO;
		} catch (Exception e) {

			return 	e.getMessage();
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
			e.getMessage();
			return false;
		}
	}
	// delete
	@DeleteMapping("/rol/{id}")
	public String deleteRol(@PathVariable Long id) {
		try {
			rolserviceimplement.delete(id);
			return Messages.ROL_ELIMINADO;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
