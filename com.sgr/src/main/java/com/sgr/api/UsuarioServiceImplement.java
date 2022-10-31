package com.sgr.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sgr.api.interfaces.UsuarioRepository;
import com.sgr.api.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sgr.bussines.Messages;
import com.sgr.entities.Usuario;

@Service
@Transactional
public class UsuarioServiceImplement implements UsuarioService {

	@Autowired
    UsuarioRepository usuarioRepository;

	@Override
	public Usuario create(Usuario usuario) {
		if(usuario.get_id()!=999999996L) {
			usuario.set_id(new Date().getTime());
		}
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(usuario.get_id());

		if (usuarioOpt.isPresent()) {
			Usuario usr = usuarioOpt.get();
			usr.set_id(usuario.get_id());
			usr.setNombre(usuario.getNombre());
			usr.setApellido(usuario.getApellido());
			usr.setApiId(usuario.getApiId());
			usr.setDireccion(usuario.getDireccion());
			usr.setDocumento(usuario.getDocumento());
			usr.setEmail(usuario.getEmail());
			usr.setRol(usuario.getRol());
			usr.setTelefono(usuario.getTelefono());
			usr.setUsername(usuario.getUsername());
			this.usuarioRepository.save(usr);
			return usr;
		} else {
			System.out.printf(Messages.usrNotFound, usuario.get_id());
			return null;
		}
	}

	@Override
	public List<Usuario> list() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario getById(Long id) {
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(Long id) {
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			try {
				this.usuarioRepository.delete(usuario.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

}
