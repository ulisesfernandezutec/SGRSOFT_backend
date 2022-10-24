package com.sgr.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.RolRepository;
import com.sgr.api.interfaces.RolService;
import com.sgr.bussines.Messages;
import com.sgr.entities.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolServiceImplement implements RolService {

	@Autowired
	RolRepository rolRepository;
	/*
	@Override
	public Rol create(Rol rol) {
		if (rol.get_id() != 999999996L) {
			rol.set_id(new Date().getTime());
		}
		return RolRepository.save(rol);
	}
	
	@Override
	public PuntoRecoleccionEstado update(PuntoRecoleccionEstado pdr) {

		Optional<PuntoRecoleccionEstado> pre = this.puntoRecoleccionEstadoRepository
				.findById(Long.parseLong(String.valueOf(pdr.get_id())));

		if (pre.isPresent()) {
			PuntoRecoleccionEstado pdre = pre.get();
			pdre.set_id(pdr.get_id());
			pdre.setFecha(pdr.getFecha());
			pdre.setDetalle(pdr.getDetalle());
			pdre.setEstado(pdr.getEstado());
			pdre.setUsuario(pdr.getUsuario());
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
	*/

	@Override
	public Rol create(Rol rol) {
		if (rol.get_id() != 999999996L) {
			rol.set_id(new Date().getTime());
		}
		return rolRepository.save(rol);

	}

	@Override
	public Rol update(Rol rol) {
		Optional<Rol> rolOpt = this.rolRepository.findById(Long.parseLong(String.valueOf(rol.get_id())));

		if (rolOpt.isPresent()) {
			Rol rol2 = rolOpt.get();
			rol2.set_id(rol.get_id());
			rol2.setNombre(rol.getNombre());
			return this.rolRepository.findById(Long.parseLong(String.valueOf(rol.get_id()))).get();
		} else {
			System.out.printf(Messages.rolNotFound, rol.get_id());
			return null;
		}
	}

	@Override
	public Rol getById(Long id) {
		Optional<Rol> pdr = this.rolRepository.findById(id);
		if (pdr.isPresent()) {
			return pdr.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(Long id) {
		Optional<Rol> rol = this.rolRepository.findById(id);
		if (rol.isPresent()) {
			try {
				this.rolRepository.delete(rol.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public List<Rol> list() {
		return this.rolRepository.findAll();
	}
}
