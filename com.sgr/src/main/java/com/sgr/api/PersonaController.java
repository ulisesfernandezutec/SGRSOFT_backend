package com.sgr.api;

import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sgr.bussines.Messages;
import com.sgr.entities.Persona;

@RestController
public class PersonaController {

	@Autowired
	PersonaServiceImplement personaService;

	//list
	@GetMapping("/persona")
	public List<Persona> getAllPersona() {
		return personaService.list();
	}
	//getone
	@GetMapping("/persona/{id}")
	public Persona getPersona(@PathVariable String id) {
		Long idl = Long.parseLong(id);
		return personaService.getById(idl);
	}
	//create
	@PostMapping("/persona/{id}")
	public boolean setPersona(@RequestBody Persona persona) {
		try {
			personaService.create(persona);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	//delete
	@DeleteMapping("/persona/{id}")
	public boolean deletePersona(@PathVariable Long id) {
		try {
			personaService.delete(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	//update
	@PostMapping("/persona/update/{id}")
	public boolean updatePersona(@RequestBody Persona persona) {
		try {
			personaService.update(persona);
			return true;
		} catch (Exception ex) {
			System.out.printf(Messages.perNotFound, persona.get_id());
			return false;
		}
	}
}
