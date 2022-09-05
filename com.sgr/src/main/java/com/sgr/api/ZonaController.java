package com.sgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.Zona;

@RestController
public class ZonaController {

	@Autowired
	private ZonaServiceImplement zonaServiceImplement;

	@GetMapping("/zona")
	public List<Zona> getAll() {
		try {
			return zonaServiceImplement.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/zona/{id}")
	public Zona getUsuario(@PathVariable int id) {
		return zonaServiceImplement.getById(id);
	}

	@PostMapping("/zona/set/")
	public boolean setZona(@RequestBody Zona zona) {
		try {
			zonaServiceImplement.create(zona);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PostMapping("/zona/update/")
	public boolean updateRol(@RequestBody Zona zona) {
		try {
			if (zonaServiceImplement.getById(zona.getId()) != null) {
				zonaServiceImplement.update(zona);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
