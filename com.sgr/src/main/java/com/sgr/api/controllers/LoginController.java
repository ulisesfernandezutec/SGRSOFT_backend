package com.sgr.api.controllers;

import com.sgr.api.interfaces.repository.UsuarioRepository;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.entities.AuthUser;
import com.sgr.entities.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@Slf4j
public class LoginController {

	@Autowired
	UsuarioRepository user;

	@PostMapping("/login")
	public AuthUser login(@RequestParam("email") String email, @RequestParam("pwd") String pwd) {
		AuthUser authUser = new AuthUser();
		
		Optional<Usuario> u = user.findFirstByEmailLike(email);
		//Veriicar PSW
		if (u.isPresent() && u.get().getPwrd().equals(pwd)) {
			String token = SecurityBussines.getJWTToken(email, u.get());
			authUser.setToken(token);
			authUser.setEmail(u.get().getEmail());
			authUser.setRol(u.get().getRol());
			authUser.setLogin("OK");
			return authUser;
		}else {
			authUser.setLogin("Usuario desconocido");
			return authUser;
		}
		
	}
}
