package com.sgr.api;

import com.sgr.api.interfaces.UsuarioRepository;
import com.sgr.bussines.security.SecurityBussines;
import com.sgr.bussines.security.exceptions.UserNotFoudException;
import com.sgr.entities.AuthUser;
import com.sgr.entities.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class LoginController {

	private final static String PREFIX = "Bearer";
	private final static String HEADER = "Authorization";
	private final static String SECRET = "sgrsoft2022";
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
