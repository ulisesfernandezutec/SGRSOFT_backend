package com.sgr.api;

import java.util.List;

import com.sgr.entities.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolController {

	@Autowired
	private RolServiceImplement rolServiceImplement;

	@GetMapping("/rol")
	public List<Rol> getAll() {
		try {
			return rolServiceImplement.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/rol/{id}")
	public Rol getRol(@PathVariable int id) {
		return rolServiceImplement.getById(id);
	}

	@PostMapping("/rol/set/")
	public boolean setRol(@RequestBody Rol rol) {
		try {
			rolServiceImplement.create(rol);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PostMapping("/rol/update/")
	public boolean updateRol(@RequestBody Rol rol) {
		try {
			if (rolServiceImplement.getById(rol.get_id()) != null) {
				rolServiceImplement.update(rol);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

}
