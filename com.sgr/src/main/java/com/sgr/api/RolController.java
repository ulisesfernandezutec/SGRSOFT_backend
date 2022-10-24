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

import com.sgr.entities.Rol;

@RestController
public class RolController {

	@Autowired
	private RolServiceImplement rolserviceimplement;
	
	//getall
	@GetMapping("/rol")
	public List<Rol> getAll() {
		try {
			return rolserviceimplement.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//getone
	@GetMapping("/rol/{id}")
	public Rol getRol(@PathVariable Long id) {
		return rolserviceimplement.getById(id);
	}
	//setone
	@PostMapping("/rol/")
	public boolean setRol(@RequestBody Rol rol) {
		try {
			rolserviceimplement.create(rol);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	@PutMapping("/rol/")
	public boolean updateRol(@RequestBody Rol rol) {
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
	public boolean deleteRol(@PathVariable Long id) {
		try {
			rolserviceimplement.delete(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
