package com.sgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.PuntoDR;

@RestController
public class PuntoDRController {

	@Autowired
	private PuntoDRServiceImplement puntoDRServiceImplement;

	@GetMapping("/puntodr")
	public List<PuntoDR> getAll() {
		try {
			return puntoDRServiceImplement.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/puntodr/{id}")
	public PuntoDR getPersona(@PathVariable int id) {
		return puntoDRServiceImplement.getById(id);
	}

	@PostMapping("/puntodr/set/")
	public boolean setPersona(@RequestBody PuntoDR puntoDr) {
		try {
			puntoDRServiceImplement.create(puntoDr);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PostMapping("/puntodr/update/")
	public boolean updatePuntoR(@RequestBody PuntoDR puntoDr) {
		try {
			if (puntoDRServiceImplement.getById(Long.parseLong(puntoDr.getId())) != null) {
				puntoDRServiceImplement.update(puntoDr);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

}
