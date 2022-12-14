package com.sgr.api.controllers;

import java.util.Optional;
import java.util.UUID;

import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import com.sgr.bussines.Messages;
import com.sgr.bussines.Utils;
import com.sgr.entities.Rol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.sgr.bussines.security.SecurityGoogleTokenVerifier;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.APOD;
import com.sgr.entities.Usuario;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
@Slf4j
@RestController
public class GoogleLogin {
	@Autowired
	UsuarioServiceImplement repo;

	@GetMapping("/glogin/{token}")
	public String getUsuarioInfo(@PathVariable String token) {
		try {
			token = token.replace("token=", "");
			APOD resp = SecurityGoogleTokenVerifier.verificar(token);
			if (resp.getError() == null && resp.getErrorDescription() == null) {
				Optional<Usuario> u = repo.findFirstByEmailLike(resp.getEmail());
				if (u.isPresent()) {
					u.get().setPwrd("****");
					String tokensgr = SecurityBussines.getJWTToken(u.get().getEmail(), u.get());
					resp.setSgrToken(tokensgr);
					resp.setUsuario(u.get());
				} else {
					String userInfo = SecurityGoogleTokenVerifier.googleUserInfo(token);
					JsonObject obj = new Gson().fromJson(userInfo, JsonObject.class);
					Usuario user = new Usuario(1L, Utils.generateRandomString(), new Rol(3, "Usuario"), "", "", "", obj.get("email").getAsString(),"", "Activo");
					repo.create(user);
					Optional<Usuario> us = repo.findFirstByEmailLike(resp.getEmail());
					if (us.isPresent()) {
						String tokensgr = SecurityBussines.getJWTToken(us.get().getEmail(), us.get());
						resp.setSgrToken(tokensgr);
					}
				}
			}
			return new Gson().toJson(resp);
		}catch(Exception e){
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.CREATE_ERROR +e.getMessage());
		}
	}
}
