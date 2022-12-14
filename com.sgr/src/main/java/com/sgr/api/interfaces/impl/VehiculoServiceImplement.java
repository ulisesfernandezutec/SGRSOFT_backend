package com.sgr.api.interfaces.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.repository.VehiculoRepository;
import com.sgr.api.interfaces.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.entities.Vehiculo;

@Service
@Transactional
public class VehiculoServiceImplement implements VehiculoService {

	@Autowired
    VehiculoRepository vehiculorepository;

	@Override
	public Vehiculo create(Vehiculo vehiculo) {
		if(vehiculo.get_id()!=999999996L) {
			vehiculo.set_id(new Date().getTime());
		}
		return vehiculorepository.save(vehiculo);
	}

	@Override
	public Vehiculo update(Vehiculo vehiculoParam) {
		Optional<Vehiculo> vehiculoOpt = this.vehiculorepository.findById(vehiculoParam.get_id());

		if (vehiculoOpt.isPresent()) {
			Vehiculo vehiculo = vehiculoOpt.get();
			vehiculo.set_id(vehiculoParam.get_id());
			vehiculo.setMarca(vehiculoParam.getMarca());
			vehiculo.setMatricula(vehiculoParam.getMatricula());
			vehiculo.setNombre(vehiculoParam.getNombre());
			vehiculo.setChofer(vehiculoParam.getChofer());
			this.vehiculorepository.save(vehiculo);
			return vehiculo;
		} else {
			return null;
		}
	}

	@Override
	public List<Vehiculo> list() {
		return this.vehiculorepository.findAll();
	}

	@Override
	public Vehiculo getById(Long id) {
		Optional<Vehiculo> vehiculo = this.vehiculorepository.findById(id);
		if (vehiculo.isPresent()) {
			return vehiculo.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(Long id) {
		Optional<Vehiculo> vehiculo = this.vehiculorepository.findById(id);
		if (vehiculo.isPresent()) {
			try {
				this.vehiculorepository.delete(vehiculo.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

}
