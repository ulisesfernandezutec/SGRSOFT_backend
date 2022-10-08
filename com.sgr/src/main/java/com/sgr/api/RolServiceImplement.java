package com.sgr.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.RolRepository;
import com.sgr.api.interfaces.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.Rol;

@Service
@Transactional
public class RolServiceImplement implements RolService {

	@Autowired
    RolRepository rolRepository;

	@Override
	public Rol create(Rol rol) {
		rol.set_id(new Date().getTime());
		return rolRepository.save(rol);
	}

	@Override
	public Rol update(Rol rolParam) {
		Optional<Rol> rolrepo = this.rolRepository.findById(rolParam.get_id());

		if (rolrepo.isPresent()) {
			Rol rol = rolrepo.get();
			rol.set_id(rolParam.get_id());
			rol.setNombre(rolParam.getNombre());
			this.rolRepository.save(rolParam);
			return rol;
		} else {
			System.out.printf(Messages.pdrNotFound, rolParam.get_id());
			return null;
		}
	}

	@Override
	public List<Rol> list() {
		return this.rolRepository.findAll();
	}

	@Override
	public Rol getById(long id) {
		Optional<Rol> rol = this.rolRepository.findById(id);
		if (rol.isPresent()) {
			return rol.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
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
}
