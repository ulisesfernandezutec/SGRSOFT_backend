package com.sgr.api.controllers;

import java.time.Year;
import java.util.List;

import com.sgr.api.interfaces.impl.TipoResiduoServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.dto.TipoResiduoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgr.entities.TipoDeResiduo;
import org.springframework.web.server.ResponseStatusException;
@Slf4j
@RestController
public class TipoResiduoController {
   	@Autowired
	private TipoResiduoServiceImplement tipoResiduoServiceImplement;

	// getall
	@GetMapping("/tiporesiduo")
	public List<TipoDeResiduo> getAll() {
		try {
			return tipoResiduoServiceImplement.list();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + Messages.TIPO_RESIDUO);
		}
	}

	// getone
	@GetMapping("/tiporesiduo/{id}")
	public TipoDeResiduo getTipoDeResiduo(@PathVariable("id") String id) {
		try{
			Long idL = Long.parseLong(id);
			return tipoResiduoServiceImplement.getById(idL);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + Messages.TIPO_RESIDUO);
		}
	}

	// setone
	@PostMapping("/tiporesiduo/")
	public String setTipoDeResiduo(@RequestBody TipoResiduoDTO tipoR) {
		try {
			TipoDeResiduo tipoDeResiduo = new TipoDeResiduo(tipoR.get_id(), tipoR.getNombre());
			tipoResiduoServiceImplement.create(tipoDeResiduo);
			return Messages.TR_CREADO;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR + Messages.TIPO_RESIDUO);
		}
	}

	// update
	@PutMapping("/tiporesiduo/")
	public boolean updateTipoDeResiduo(@RequestBody TipoResiduoDTO tipoRs) {
		try {
			TipoDeResiduo tipoDeResiduo = new TipoDeResiduo(tipoRs.get_id(), tipoRs.getNombre());
			if (tipoResiduoServiceImplement.getById(tipoDeResiduo.get_id()) != null) {
				tipoResiduoServiceImplement.update(tipoDeResiduo);
			}
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR + Messages.TIPO_RESIDUO);
		}
	}

	// delete
	@DeleteMapping("/tiporesiduo/{id}")
	public String deleteTipoDeResiduo(@PathVariable Long id) {
		try {
			tipoResiduoServiceImplement.delete(id);
			return Messages.TR_ELIMINADO;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR + Messages.TIPO_RESIDUO);
		}
	}

}
