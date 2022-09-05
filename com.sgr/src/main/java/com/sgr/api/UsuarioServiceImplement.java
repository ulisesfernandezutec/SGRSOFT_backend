package com.sgr.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgr.bussines.Messages;
import com.sgr.entities.Persona;
import com.sgr.entities.PuntoDR;
import com.sgr.entities.TipoDeResiduo;
import com.sgr.entities.Usuario;

@Service
@Transactional
public class UsuarioServiceImplement implements UsuarioService {

	@Autowired
	UsuarioRepository usuariorepository;

	@Override
	public Usuario create(Usuario user) {
		return usuariorepository.save(user);
	}

	@Override
	public Usuario update(Usuario user) {
		Optional<Usuario> userOpt = this.usuariorepository.findById(user.getId());

		if (userOpt.isPresent()) {
			Usuario usr = userOpt.get();
			usr.setId(user.getId());
			usr.setUsuario(user.getUsuario());
			usr.setContraseña(user.getContraseña());
			this.usuariorepository.save(usr);
			return usr;
		} else {
			System.out.printf(Messages.pusNotFound, user.getId());
			return null;
		}
	}

	@Override
	public List<Usuario> list() {
		return this.usuariorepository.findAll();
	}

	@Override
	public Usuario getById(long id) {
		Optional<Usuario> usr = this.usuariorepository.findById(id);
		if (usr.isPresent()) {
			return usr.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(long id) {
		Optional<Usuario> urs = this.usuariorepository.findById(id);
		if (urs.isPresent()) {
			try {
				this.usuariorepository.delete(urs.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
