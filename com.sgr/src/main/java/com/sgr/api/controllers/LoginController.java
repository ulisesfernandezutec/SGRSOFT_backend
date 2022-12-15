package com.sgr.api.controllers;

import com.google.gson.*;
import com.sgr.api.interfaces.impl.EmailServiceImplement;
import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.bussines.Utils;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.AuthUser;
import com.sgr.entities.Email;
import com.sgr.entities.Usuario;
import com.sgr.entities.dto.UsuarioDTO;
import com.sgr.entities.dto.google.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.mail.internet.AddressException;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class LoginController {

	@Autowired
	UsuarioServiceImplement user;
	@Autowired
	EmailServiceImplement emailServiceImplement;
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
				Usuario usuario = new Usuario(usuarioDTO.get_id(), usuarioDTO.getPwrd(), usuarioDTO.getRol(), usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getTelefono(), usuarioDTO.getEmail(), usuarioDTO.getDireccion(), usuarioDTO.getEstado());
				Long id = 0L;
				usuario.set_id(id);
				UUID ui = UUID.randomUUID();
				usuario.setEstado(ui.toString());
				user.create(usuario);
				usr = user.findFirstByEmailLike(usuarioDTO.getEmail());
				if(usr.isPresent()){
					//Crear email
					Email mail = new Email();
					mail.setRecipient(usr.get().getEmail());
					mail.setSubject(Messages.ACTIVE);
					String msg = "Clic en el enlace para activar el usuario\r\n"+"https://api.karaiguazu.com/login/newuserok/?uuid="+usr.get().getEstado();
					mail.setMsgBody(msg);
					emailServiceImplement.sendSimpleMail(mail);
				}
				return usr.orElse(null);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR + e.getMessage());
			}
		}else {
			log.error(Messages.CREATE_ERROR + Messages.EMAIL_EXIST);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR + Messages.EMAIL_EXIST);
		}
	}
}
