package com.sgr.api;

import com.sgr.bussines.*;
import com.sgr.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
	
	//private static final Logger logger = new LoggerFactory().getLogger(PersonaController.class);
	
	@Autowired
	PersonaServiceImplement personaService;
	
	
	// list
	@GetMapping("/persona")
	public List<Persona> getAllPersona() {

		return personaService.list();
	}

	// getone
	@GetMapping("/persona/{id}")
	public Persona getPersona(@PathVariable String id) {
		Long idl = Long.parseLong(id);
		return personaService.getById(idl);
	}

	// create
	@PostMapping("/persona/")
	public boolean setPersona(@RequestBody Persona persona) {
		try {
			personaService.create(persona);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// update
	@PutMapping("/persona/")
	public boolean updatePersona(@RequestBody Persona persona) {
		try {
			personaService.update(persona);
			return true;
		} catch (Exception ex) {
			System.out.printf(Messages.perNotFound, persona.get_id());
			return false;
		}
	}

	// delete
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
}
