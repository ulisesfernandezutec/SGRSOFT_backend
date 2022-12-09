package com.sgr.api.controllers;

import java.util.Optional;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import com.sgr.entities.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.sgr.bussines.security.SecurityGoogleTokenVerifier;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.APOD;
import com.sgr.entities.Usuario;
@RestController
public class GoogleLogin {
	@Autowired
	UsuarioServiceImplement repo;

	@GetMapping("/glogin/{token}")
	public String getUsuarioInfo(@PathVariable String token) {
		token = token.replace("token=", "");
		APOD resp = SecurityGoogleTokenVerifier.verificar(token);
		if (resp.getError() == null && resp.getErrorDescription() == null) {
			Optional<Usuario> u = repo.findFirstByEmailLike(resp.getEmail());
			if (u.isPresent()) {
				resp.setRol(u.get().getRol().toString());
				String tokensgr = SecurityBussines.getJWTToken(u.get().getEmail(), u.get());
				resp.setSgrToken(tokensgr);


			} else {
				String userInfo = SecurityGoogleTokenVerifier.googleUserInfo(token);
				JsonObject obj = new Gson().fromJson(userInfo, JsonObject.class);
				Usuario user = new Usuario(1L,"",new Rol(3, "USER"),"","","","",obj.get("email").getAsString(),"");
				repo.create(user);
				Optional<Usuario> us = repo.findFirstByEmailLike(resp.getEmail());
				if(us.isPresent()){
					String tokensgr = SecurityBussines.getJWTToken(us.get().getEmail(), us.get());
					resp.setSgrToken(tokensgr);
				}
			}
		}
		return new Gson().toJson(resp);
	}
}
