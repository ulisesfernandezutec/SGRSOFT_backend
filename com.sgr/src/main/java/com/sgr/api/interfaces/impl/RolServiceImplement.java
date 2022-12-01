package com.sgr.api.interfaces.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.repository.RolRepository;
import com.sgr.api.interfaces.service.RolService;
import com.sgr.bussines.Messages;
import com.sgr.entities.Rol;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@Transactional
public class RolServiceImplement implements RolService {

	@Autowired
	RolRepository rolRepository;

	@Override
	public Rol create(Rol rol) {
		if (rol.get_id() != 999999996L) {
			rol.set_id(new Date().getTime());
		}
		return rolRepository.save(rol);

	}

	@Override
	public Rol update(Rol rol) {
		Optional<Rol> rolOp = this.rolRepository.findById(Long.parseLong(String.valueOf(rol.get_id())));

		if (rolOp.isPresent()) {
			Rol rol2 = rolOp.get();
			rol2.setNombre(rol.getNombre());
			rolRepository.save(rol2);
		} else {
			log.error(Messages.ROL_NOT_FOUND, rol.get_id());
		}
		Optional<Rol> ret = this.rolRepository.findById(Long.parseLong(String.valueOf(rol.get_id())));
		return ret.isPresent() ? ret.get():null;
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
