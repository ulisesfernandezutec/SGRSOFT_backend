package com.sgr.api;

import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.TipoResiduoRepository;
import com.sgr.api.interfaces.TipoResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.TipoDeResiduo;

@Service
@Transactional
public class TipoResiduoServiceImplement implements TipoResiduoService {

	@Autowired
    TipoResiduoRepository tipoResiduoRepository;

	@Override
	public TipoDeResiduo create(TipoDeResiduo tipoDeResiduo) {
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
			System.out.printf(Messages.ptrNotFound, tipoDeResiduo.get_id());
			return null;
		}
	}

	@Override
	public List<TipoDeResiduo> list() {
		return this.tipoResiduoRepository.findAll();
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
