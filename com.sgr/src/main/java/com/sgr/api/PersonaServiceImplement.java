package com.sgr.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.Persona;

@Service
@Transactional
public class PersonaServiceImplement implements PersonaService {

	@Autowired
	PersonaRepository personarepository;

	@Override
	public Persona create(Persona persona) {
		return personarepository.save(persona);
	}

	@Override
	public Persona update(Persona persona) {
		Optional<Persona> personarepo = this.personarepository.findById(persona.getId());

		if (personarepo.isPresent()) {
			Persona pu = personarepo.get();
			pu.setId(persona.getId());
			pu.setNombre(persona.getNombre());
			pu.setApellido(persona.getApellido());
			pu.setTelefono(persona.getTelefono());
			pu.setDireccion(persona.getTelefono());
			pu.setObservaciones(persona.getObservaciones());
			this.personarepository.save(pu);
			return pu;
		} else {
			System.out.printf(Messages.personaNotFound, persona.getId());
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

	@Override
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
