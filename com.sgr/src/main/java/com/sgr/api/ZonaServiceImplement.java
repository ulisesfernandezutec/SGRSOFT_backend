package com.sgr.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.Vehiculo;
import com.sgr.entities.Zona;

@Service
@Transactional
public class ZonaServiceImplement implements ZonaService {

	@Autowired
	ZonaRepository zonarepository;

	@Override
	public Zona create(Zona zona) {
		return zonarepository.save(zona);
	}

	@Override
	public Zona update(Zona zonaParam) {
		Optional<Zona> zonaOpt = this.zonarepository.findById(zonaParam.getId());

		if (zonaOpt.isPresent()) {
			Zona zona = zonaOpt.get();
			zona.setId(zonaParam.getId());
			zona.setNombre(zonaParam.getNombre());
			zona.setCoordenadas(zonaParam.getCoordenadas());
			this.zonarepository.save(zona);
			return zona;
		} else {
			System.out.printf(Messages.pznNotFound, zonaParam.getId());
			return null;
		}
	}

	@Override
	public List<Zona> list() {
		return this.zonarepository.findAll();
	}

	@Override
	public Zona getById(long id) {
		Optional<Zona> zona = this.zonarepository.findById(id);
		if (zona.isPresent()) {
			return zona.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		Optional<Zona> zonaOpt = this.zonarepository.findById(id);
		if (zonaOpt.isPresent()) {
			try {
				this.zonarepository.delete(zonaOpt.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
