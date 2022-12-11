package com.sgr.api.controllers;

import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.entities.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.sgr.entities.Usuario;
import org.springframework.web.server.ResponseStatusException;
import org.w3c.dom.html.HTMLTableRowElement;

@Slf4j
@RestController
public class UsuarioController {

	@Autowired
    UsuarioServiceImplement usuarioRepository;

	// getall
	@GetMapping("/usr")
	public List<Usuario> getAll() {
		try {
			return usuarioRepository.list();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + e.getMessage());
		}
	}

	// getone
	@GetMapping("/usr/{id}")
	public Usuario getUsuario(@PathVariable("id") String id) {
		try {
			return usuarioRepository.getById(Long.parseLong(id));
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + e.getMessage());
		}
	}

	//GetByEmail
	@GetMapping("/usr/{email}")
	public Usuario getUsuarioByEmail(@PathVariable("email") String email) {
		try{
			Optional<Usuario>usr = usuarioRepository.findFirstByEmailLike(email);
			return usr.isPresent()?usr.get():null;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.READ_ERROR + e.getMessage());
		}
	}

	// setone
	@PostMapping("/usr")
	public Usuario setUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO.get_id(), usuarioDTO.getPwrd(), usuarioDTO.getRol(), usuarioDTO.getNombre(), usuarioDTO.getApellido(),usuarioDTO.getDocumento(), usuarioDTO.getTelefono(), usuarioDTO.getEmail(), usuarioDTO.getDireccion(), usuarioDTO.getEstado());
		try {
			Long id = 0L;
			usuarioRepository.create(usuario);
			Optional<Usuario> usr = usuarioRepository.findFirstByEmailLike(usuario.getEmail());
			return usr.isPresent()?usr.get():null;

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR + e.getMessage());
		}
	}

	// update
	@PutMapping("/usr")
	public boolean updateUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO.get_id(), usuarioDTO.getPwrd(), usuarioDTO.getRol(), usuarioDTO.getNombre(), usuarioDTO.getApellido(),usuarioDTO.getDocumento(), usuarioDTO.getTelefono(), usuarioDTO.getEmail(), usuarioDTO.getDireccion(), usuarioDTO.getEstado());
		try {
			if (usuarioRepository.getById(usuario.get_id()) != null) {
				usuarioRepository.update(usuario);
			}
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.UPDATE_ERROR + e.getMessage());
		}
	}

	// delete
	@DeleteMapping("/usr/{id}")
	public String deleteUsuario(@PathVariable Long id) {
		try {
			usuarioRepository.delete(id);
			return Messages.USR_ELIMINADO;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.DELETE_ERROR + e.getMessage());
		}
	}
}
