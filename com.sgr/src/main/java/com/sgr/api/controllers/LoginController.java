package com.sgr.api.controllers;

import com.google.gson.*;
import com.sgr.api.interfaces.repository.UsuarioRepository;
import com.sgr.bussines.Messages;
import com.sgr.bussines.Utils;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.AuthUser;
import com.sgr.entities.Usuario;
import com.sgr.entities.dto.UsuarioDTO;
import com.sgr.entities.dto.google.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.internet.AddressException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class LoginController {

	@Autowired
	UsuarioRepository user;

	@PostMapping("/login")
	public AuthUser login(@RequestBody LoginDTO loginDTO) {
		String email;
		String pwd;
		try {
			email = Utils.validarEmail(loginDTO.getEmail())?loginDTO.getEmail():null;
			pwd = loginDTO.getPwd();
		}catch(JsonParseException pe){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.ERROR + pe.getMessage());
		} catch (AddressException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.ERROR + e.getMessage());
		}
		Optional<Usuario> u = user.findFirstByEmailLike(email);
		AuthUser authUser = new AuthUser();
		//Veriicar PSW
		if (u.isPresent() && u.get().getPwrd().equals(pwd)) {
			String token = SecurityBussines.getJWTToken(email, u.get());
			authUser.setSgrToken(token);
			Usuario usuario = u.get();
			usuario.setPwrd("****");
			authUser.setUsuario(usuario);
			return authUser;
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.PERSONA_NOT_FOUND + authUser.getUsuario().getEmail());
		}
	}
	@PostMapping("/login/newuser")
	public Usuario setNewUsuario(@RequestBody UsuarioDTO usuarioDTO) throws AddressException {
		boolean ok;
		ok = Utils.validarEmail(usuarioDTO.getEmail());
		Optional <Usuario> usr =user.findFirstByEmailLike(usuarioDTO.getEmail());
		//Comprobar existencia
		if(usr.isEmpty() && ok){
			try {
				Usuario usuario = new Usuario(usuarioDTO.get_id(), usuarioDTO.getPwrd(), usuarioDTO.getRol(), usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getDocumento(), usuarioDTO.getTelefono(), usuarioDTO.getEmail(), usuarioDTO.getDireccion(), usuarioDTO.getEstado());
				Long id = 0L;
				usuario.set_id(id);
				UUID ui = UUID.randomUUID();
				usuario.setEstado(ui.toString());
				user.save(usuario);
				usr = user.findFirstByEmailLike(usuarioDTO.getEmail());
				Utils.crearEmailValidación(ui,usuario.getEmail());

				return usr.orElse(null);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR + e.getMessage());
			}
		}else {
			log.error(Messages.CREATE_ERROR + Messages.EMAIL_EXIST);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR + Messages.EMAIL_EXIST);
		}

	}@GetMapping("/login/newuserok")
	public String allArticles(@PathVariable String uuid, Model model) {
		Optional <Usuario> usr =user.findFirstByEstadoLike(uuid);
		Usuario usuario = new Usuario();
		if(usr.isPresent()){
		 	usuario = usr.get();
		}
		model.addAttribute("email",usuario.getEmail());
		return "confirm/confirm";
	}
}
