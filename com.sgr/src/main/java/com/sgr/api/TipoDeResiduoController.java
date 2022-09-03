package com.sgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.PuntoDR;
import com.sgr.entities.Rol;
import com.sgr.entities.TipoDeResiduo;

@RestController
public class TipoDeResiduoController {

	@Autowired
	private TipoResiduoServiceImplement tipoResiduoServiceImplement;

	@GetMapping("/tiporesiduo")
	public List<TipoDeResiduo> getAll() {
		try {
			return tipoResiduoServiceImplement.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/tiporesiduo/{id}")
	public TipoDeResiduo getRol(@PathVariable int id) {
		return tipoResiduoServiceImplement.getById(id);
	}

	@PostMapping("/tiporesiduo/set/")
	public boolean setRol(@RequestBody TipoDeResiduo tipoR) {
		try {
			tipoResiduoServiceImplement.create(tipoR);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PostMapping("/tiporesiduo/update/")
	public boolean updateRol(@RequestBody TipoDeResiduo tipoRs) {
		try {
			if (tipoResiduoServiceImplement.getById(Long.parseLong(tipoRs.getId())) != null) {
				tipoResiduoServiceImplement.update(tipoRs);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

}
