package com.sgr.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.sgr.bussines.Messages;
import com.sgr.entities.Persona;

@RestController
public class PersonaController {
	
	//private static final Logger logger = new LoggerFactory().getLogger(PersonaController.class);
	
	@Autowired
	PersonaServiceImplement personaService;
	
	
	
	// list
	@GetMapping("/persona")
	public List<Persona> getAllPersona() {
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Principal ="+auth.getPrincipal());
		System.out.println("Datos de los permisos ="+auth.getAuthorities());
		System.out.println("Está autenticado="+auth.isAuthenticated());*/
		return personaService.list();
	}

	// getone
	@GetMapping("/persona/{id}")
	public Persona getPersona(@PathVariable String id) {
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Principal ="+auth.getPrincipal());
		System.out.println("Datos de los permisos ="+auth.getAuthorities());
		System.out.println("Está autenticado="+auth.isAuthenticated());*/
		Long idl = Long.parseLong(id);
		return personaService.getById(idl);
	}

	// create
	@PostMapping("/persona/")
	public boolean setPersona(@RequestBody Persona persona) {
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Principal ="+auth.getPrincipal());
		System.out.println("Datos de los permisos ="+auth.getAuthorities());
		System.out.println("Está autenticado="+auth.isAuthenticated());*/
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
			/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("Principal ="+auth.getPrincipal());
			System.out.println("Datos de los permisos ="+auth.getAuthorities());
			System.out.println("Está autenticado="+auth.isAuthenticated());*/
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
			/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("Principal ="+auth.getPrincipal());
			System.out.println("Datos de los permisos ="+auth.getAuthorities());
			System.out.println("Está autenticado="+auth.isAuthenticated());*/
			personaService.delete(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
