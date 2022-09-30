package com.sgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entities.Usuario;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioServiceImplement usuarioServiceImplement;

	// getall
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

	// getone
	@GetMapping("/usuario/{id}")
	public Usuario getUsuario(@PathVariable int id) {
		return usuarioServiceImplement.getById(id);
	}

	// setone
	@PostMapping("/usuario/")
	public boolean setUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioServiceImplement.create(usuario);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	@PutMapping("/usuario/")
	public boolean updateUsuario(@RequestBody Usuario usuario) {
		try {
			if (usuarioServiceImplement.getById(usuario.get_id()) != null) {
				usuarioServiceImplement.update(usuario);
			}
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// delete
	@DeleteMapping("/usuario/{id}")
	public boolean deleteUsuario(@PathVariable Long id) {
		try {
			usuarioServiceImplement.delete(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
