package com.sgr.api;

import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.bussines.Messages;
import com.sgr.entities.Persona;

@RestController
public class PersonaController {

	@Autowired
	private PersonaServiceImplement personaService;

	@GetMapping("/persona")
	public List<Persona> getAllPersona() {
		return personaService.list();
	}

	@GetMapping("/persona/{id}")
	public Persona getPersona(@PathVariable Long id) {
		return personaService.getById(id);
	}

	@PostMapping("/persona/set/")
	public boolean setPersona(@RequestBody Persona persona) {
		try {
			personaService.create(persona);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PostMapping("/persona/update/")
	public boolean updatePersona(@RequestBody Persona persona) {

		try {
			personaService.update(persona);
			return true;
		} catch (Exception ex) {
			System.out.printf(Messages.perNotFound, persona.getId());
			return false;
		}

	}

}
