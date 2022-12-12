package com.sgr.api.controllers;

import com.google.gson.*;
import com.sgr.api.interfaces.repository.UsuarioRepository;
import com.sgr.bussines.Messages;
import com.sgr.bussines.Utils;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.AuthUser;
import com.sgr.entities.Usuario;
import com.sgr.entities.dto.google.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@RestController
@Slf4j
public class LoginController {

	@Autowired
	UsuarioRepository user;

	@PostMapping("/login")
	public AuthUser login(@RequestBody LoginDTO loginDTO) {
		String email = "";
		String pwd = "";
		try {
			email = Utils.validarEmail(loginDTO.getEmail())?loginDTO.getEmail():null;
			pwd = loginDTO.getPwd();
		}catch(JsonParseException pe){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.ERROR + pe.getMessage());
		}
		Optional<Usuario> u = user.findFirstByEmailLike(email);
		AuthUser authUser = new AuthUser();
		//Veriicar PSW
		if (u.isPresent() && u.get().getPwrd().equals(pwd)) {
			String token = SecurityBussines.getJWTToken(email, u.get());
			authUser.setToken(token);
			authUser.setEmail(u.get().getEmail());
			authUser.setRol(u.get().getRol());
			authUser.setLogin("OK");
			return authUser;
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.PERSONA_NOT_FOUND + authUser.getEmail());
		}
		
	}
}
