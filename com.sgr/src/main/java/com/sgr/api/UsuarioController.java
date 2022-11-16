package com.sgr.api;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import com.sgr.api.interfaces.UsuarioRepository;
import com.sgr.entities.Usuario;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioServiceImplement usuarioRepository;

	// getall
	@GetMapping("/usr")
	public List<Usuario> getAll() {
		try {
			List<Usuario> lista = usuarioRepository.list();
			return lista;

		} catch (NullPointerException e) {

			e.printStackTrace();
			return null;
		}
	}

	// getone
	@GetMapping("/usr/{id}")
	public Usuario getUsuario(@PathVariable("id") String id) {
		Usuario usuario = usuarioRepository.getById(Long.parseLong(id));
		return usuario;
	}

	// setone
	@PostMapping("/usr")
	public boolean setUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioRepository.create(usuario);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// update
	@PutMapping("/usr")
	public boolean updateUsuario(@RequestBody Usuario usuario) {
		try {
			if (usuarioRepository.getById(usuario.get_id()) != null) {
				usuarioRepository.update(usuario);
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
			usuarioRepository.delete(id);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
