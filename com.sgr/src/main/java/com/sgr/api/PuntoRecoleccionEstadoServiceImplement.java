package com.sgr.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.sgr.api.interfaces.PuntoDeRecoleccionRepository;
import com.sgr.api.interfaces.PuntoDeRecoleccionService;
import com.sgr.api.interfaces.PuntoRecoleccionEstadoRepository;
import com.sgr.api.interfaces.PuntoRecoleccionEstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sgr.bussines.Messages;
import com.sgr.entities.PuntoRecoleccion;
import com.sgr.entities.PuntoRecoleccionEstado;

@Service
@Transactional
public class PuntoRecoleccionEstadoServiceImplement implements PuntoRecoleccionEstadoService {

	@Autowired
	PuntoRecoleccionEstadoRepository puntoRecoleccionEstadoRepository;
	
	@Override
	public PuntoRecoleccionEstado create(PuntoRecoleccionEstado pdr) {
		if (pdr.get_id() != 999999996L) {
			pdr.set_id(new Date().getTime());
		}
		return puntoRecoleccionEstadoRepository.save(pdr);
	}

	@Override
	public PuntoRecoleccionEstado update(PuntoRecoleccionEstado pdr) {

		Optional<PuntoRecoleccionEstado> pre = this.puntoRecoleccionEstadoRepository.findById(Long.parseLong(String.valueOf(pdr.get_id())));

		if (pre.isPresent()) {
			PuntoRecoleccionEstado pdre = pre.get();
			pdre.set_id(pdr.get_id());
			pdre.setFecha(pdr.getFecha());
			pdre.setDetalle(pdr.getDetalle());
			pdre.setEstado(pdr.getEstado());
			pdre.setUsuario(pdr.getUsuario());
			this.puntoRecoleccionEstadoRepository.save(pdre);
			return this.puntoRecoleccionEstadoRepository.findById(Long.parseLong(String.valueOf(pdr.get_id()))).get();
		} else {
			System.out.printf(Messages.pdrNotFound, pdr.get_id());
			return null;
		}
	}

	@Override
	public PuntoRecoleccionEstado getById(long id) {
		Optional<PuntoRecoleccionEstado> pdr = this.puntoRecoleccionEstadoRepository.findById(id);
		if (pdr.isPresent()) {
			return pdr.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		Optional<PuntoRecoleccionEstado> pdr = this.puntoRecoleccionEstadoRepository.findById(id);
		if (pdr.isPresent()) {
			try {
				this.puntoRecoleccionEstadoRepository.delete(pdr.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public List<PuntoRecoleccionEstado> list() {
		return this.puntoRecoleccionEstadoRepository.findAll();
	}

}
