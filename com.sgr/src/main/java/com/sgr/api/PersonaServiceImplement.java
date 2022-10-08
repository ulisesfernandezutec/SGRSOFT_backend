package com.sgr.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.PersonaRepository;
import com.sgr.api.interfaces.PersonaService;
import com.sgr.bussines.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.Persona;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
@Transactional
public class PersonaServiceImplement implements PersonaService {

	@Autowired
    PersonaRepository personarepository;

	@Override
	public Persona create(Persona persona) {
		persona.set_id(new Date().getTime());
		return personarepository.save(persona);
	}

	@Override
	public Persona update(Persona persona) {
		Optional<Persona> personarepo = this.personarepository.findById(persona.get_id());

		if (personarepo.isPresent()) {
			Persona pu = personarepo.get();
			pu.set_id(persona.get_id());
			pu.setNombre(persona.getNombre());
			pu.setApellido(persona.getApellido());
			pu.setTelefono(persona.getTelefono());
			pu.setDireccion(persona.getTelefono());
			pu.setObservaciones(persona.getObservaciones());
			this.personarepository.save(pu);
			return pu;
		} else {
			System.out.printf(Messages.personaNotFound, persona.get_id());
			return null;
		}
	}

	@Override
	public List<Persona> list() {

		return this.personarepository.findAll();
	}

	@Override
	public Persona getById(Long p) {
		Optional<Persona> personarepo = this.personarepository.findById(p);
		if (personarepo.isPresent()) {
			return personarepo.get();
		} else {
			return null;
		}
	}

	@DeleteMapping("/employees/{id}")
	public boolean delete(Long id) {
		Optional<Persona> personarepo = this.personarepository.findById(id);
		if (personarepo.isPresent()) {
			try {
				this.personarepository.delete(personarepo.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
