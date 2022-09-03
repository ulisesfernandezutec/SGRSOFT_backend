package com.sgr.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.Vehiculo;

@Service
@Transactional
public class VehiculoServiceImplement implements VehiculoService {

	@Autowired
	VehiculoRepository vehiculorepository;

	@Override
	public Vehiculo create(Vehiculo vehiculo) {
		return vehiculorepository.save(vehiculo);
	}

	@Override
	public Vehiculo update(Vehiculo vehiculoParam) {
		Optional<Vehiculo> vehiculoOpt = this.vehiculorepository.findById(Long.parseLong(vehiculoParam.getId()));

		if (vehiculoOpt.isPresent()) {
			Vehiculo vehiculo = vehiculoOpt.get();
			vehiculo.setId(vehiculoParam.getId());
			vehiculo.setMarca(vehiculoParam.getMarca());
			vehiculo.setMatricula(vehiculoParam.getMatricula());
			vehiculo.setNombre(vehiculoParam.getNombre());
			vehiculo.setChofer(vehiculoParam.getChofer());
			this.vehiculorepository.save(vehiculo);
			return vehiculo;
		} else {
			System.out.printf(Messages.pdrNotFound, vehiculoParam.getId());
			return null;
		}
	}

	@Override
	public List<Vehiculo> list() {
		return this.vehiculorepository.findAll();
	}

	@Override
	public Vehiculo getById(long id) {
		Optional<Vehiculo> vehiculo = this.vehiculorepository.findById(id);
		if (vehiculo.isPresent()) {
			return vehiculo.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
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
