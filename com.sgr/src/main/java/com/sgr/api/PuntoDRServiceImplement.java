package com.sgr.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.PuntoDRRepository;
import com.sgr.api.interfaces.PuntoDRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.PuntoDR;

@Service
@Transactional
public class PuntoDRServiceImplement implements PuntoDRService {

	@Autowired
    PuntoDRRepository puntoDRRepository;

	@Override
	public PuntoDR create(PuntoDR puntoDR) {
		puntoDR.set_id(new Date().getTime());
		return puntoDRRepository.save(puntoDR);
	}

	@Override
	public PuntoDR update(PuntoDR puntoDR) {
		Optional<PuntoDR> puntodrrepo = this.puntoDRRepository.findById(Long.parseLong(String.valueOf(puntoDR.get_id())));

		if (puntodrrepo.isPresent()) {
			PuntoDR pdr = puntodrrepo.get();
			pdr.set_id(puntoDR.get_id());
			pdr.setTipoDeResiduo(puntoDR.getTipoDeResiduo());
			pdr.setUsuario(puntoDR.getUsuario());
			pdr.setLatitud(puntoDR.getLatitud());
			pdr.setLatitud(puntoDR.getLatitud());
			this.puntoDRRepository.save(pdr);
			return pdr;
		} else {
			System.out.printf(Messages.pdrNotFound, puntoDR.get_id());
			return null;
		}
	}

	@Override
	public List<PuntoDR> list() {
		return this.puntoDRRepository.findAll();
	}

	@Override
	public PuntoDR getById(long id) {
		Optional<PuntoDR> pdr = this.puntoDRRepository.findById(id);
		if (pdr.isPresent()) {
			return pdr.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		Optional<PuntoDR> pdr = this.puntoDRRepository.findById(id);
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
}
