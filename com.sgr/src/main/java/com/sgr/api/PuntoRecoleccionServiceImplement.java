package com.sgr.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.sgr.api.interfaces.PuntoDeRecoleccionRepository;
import com.sgr.api.interfaces.PuntoDeRecoleccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sgr.bussines.Messages;
import com.sgr.entities.PuntoRecoleccion;

@Service
@Transactional
public class PuntoRecoleccionServiceImplement implements PuntoDeRecoleccionService {

	@Autowired
	PuntoDeRecoleccionRepository puntoDRRepository;

	@Override
	public PuntoRecoleccion create(PuntoRecoleccion pdr) {
		if (pdr.get_id() != 999999996L) {
			pdr.set_id(new Date().getTime());
		}
		return puntoDRRepository.save(pdr);

	}

	@Override
	public PuntoRecoleccion update(PuntoRecoleccion pdr) {
		Optional<PuntoRecoleccion> puntodrrepo = this.puntoDRRepository
				.findById(Long.parseLong(String.valueOf(pdr.get_id())));

		if (puntodrrepo.isPresent()) {
			PuntoRecoleccion pdr2 = puntodrrepo.get();
			pdr2.set_id(pdr.get_id());
			pdr2.setTipo(pdr.getTipo());
			pdr2.setUsuario(pdr.getUsuario());
			pdr2.setLatitud(pdr.getLatitud());
			pdr2.setLongitud(pdr.getLongitud());
			this.puntoDRRepository.save(pdr);
			return this.puntoDRRepository.findById(Long.parseLong(String.valueOf(pdr.get_id()))).get();
		} else {
			System.out.printf(Messages.pdrNotFound, pdr.get_id());
			return null;
		}

	}

	@Override
	public PuntoRecoleccion getById(long id) {
		Optional<PuntoRecoleccion> pdr = this.puntoDRRepository.findById(id);
		if (pdr.isPresent()) {
			return pdr.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		Optional<PuntoRecoleccion> pdr = this.puntoDRRepository.findById(id);
		if (pdr.isPresent()) {
			try {
				this.puntoDRRepository.delete(pdr.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public List<PuntoRecoleccion> list() {
		return this.puntoDRRepository.findAll();
	}
}
