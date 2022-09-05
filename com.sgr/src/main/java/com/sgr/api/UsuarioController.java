package com.sgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.Usuario;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioServiceImplement usuarioServiceImplement;

	@GetMapping("/usuario")
	public List<Usuario> getAll() {
		try {
			return usuarioServiceImplement.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/usuario/{id}")
	public Usuario getUsuario(@PathVariable int id) {
		return usuarioServiceImplement.getById(id);
	}

	@PostMapping("/usuario/set/")
	public boolean setUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioServiceImplement.create(usuario);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PostMapping("/usuario/update/")
	public boolean updateRol(@RequestBody Usuario usuario) {
		try {
			if (usuarioServiceImplement.getById(usuario.getId()) != null) {
				usuarioServiceImplement.update(usuario);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
