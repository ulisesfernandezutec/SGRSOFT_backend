package com.sgr.api.interfaces.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.repository.TipoResiduoRepository;
import com.sgr.api.interfaces.service.TipoResiduoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.TipoDeResiduo;

@Service
@Slf4j
@Transactional
public class TipoResiduoServiceImplement implements TipoResiduoService {

	@Autowired
    TipoResiduoRepository tipoResiduoRepository;

	@Override
	public TipoDeResiduo create(TipoDeResiduo tipoDeResiduo) {
		if(tipoDeResiduo.get_id()!=999999996L || tipoDeResiduo.get_id()==null) {
			tipoDeResiduo.set_id(new Date().getTime());
		}
		return tipoResiduoRepository.save(tipoDeResiduo);
	}

	@Override
	public TipoDeResiduo update(TipoDeResiduo tipoDeResiduo) {
		Optional<TipoDeResiduo> tiporepo = this.tipoResiduoRepository.findById(tipoDeResiduo.get_id());

		if (tiporepo.isPresent()) {
			TipoDeResiduo tpr = tiporepo.get();
			tpr.set_id(tipoDeResiduo.get_id());
			tpr.setNombre(tipoDeResiduo.getNombre());
			this.tipoResiduoRepository.save(tpr);
			return tpr;
		} else {
			log.error(Messages.PTR_NOT_FOUND, tipoDeResiduo.get_id());
			return null;
		}
	}

	@Override
	public TipoDeResiduo getById(long id) {
		Optional<TipoDeResiduo> tpr = this.tipoResiduoRepository.findById(id);
		if (tpr.isPresent()) {
			return tpr.get();
		} else {
			return null;
		}
	}

	@Override
	public List<TipoDeResiduo> list() {
		return this.tipoResiduoRepository.findAll();
	}

	@Override
	public boolean delete(long id) {
		Optional<TipoDeResiduo> tpr = this.tipoResiduoRepository.findById(id);
		if (tpr.isPresent()) {
			try {
				this.tipoResiduoRepository.delete(tpr.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
