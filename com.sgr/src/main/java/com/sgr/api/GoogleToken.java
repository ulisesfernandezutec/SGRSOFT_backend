package com.sgr.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sgr.api.interfaces.UsuarioRepository;
import com.sgr.bussines.security.SecurityGoogleTokenVerifier;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.APOD;
import com.sgr.entities.Usuario;

@RestController
public class GoogleToken {
	@Autowired
	UsuarioRepository repo;

	@GetMapping("/glogin/{token}")
	public String getUsuario(@PathVariable String token) {
		token = token.replace("token=", "");
		APOD resp = SecurityGoogleTokenVerifier.verificar(token);
		if (resp.error == null && resp.error_description == null) {
			Optional<Usuario> u = repo.findByEmailLike(resp.getEmail());
			if (u.isPresent()) {
				String tokensgr = SecurityBussines.getJWTToken(u.get().getUsername(), u.get());
				resp.sgrToken = tokensgr;
			} else {
				resp.sgrToken = "Usuario desconocido";
			}
		}
		return new Gson().toJson(resp);
	}
}
