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
	@GetMapping("/usr")
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
	@GetMapping("/usr/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return usuarioServiceImplement.getById(id);
	}

	//setone
	@PostMapping("/usr/")
	public boolean setUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioServiceImplement.create(usuario);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// update
	@PutMapping("/usr/")
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
	@DeleteMapping("/usr/{id}")
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
