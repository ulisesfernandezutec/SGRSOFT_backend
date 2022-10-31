package com.sgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.bussines.security.GoogleSecurityTokenVerifier;
import com.sgr.entities.Usuario;

@RestController
public class GoogleTokenVer {

	@Autowired
	private UsuarioServiceImplement usuarioServiceImplement;

	// getone
	@GetMapping("/verifyg/{id}")
	public String getUsuario(@PathVariable String id) {
		return GoogleSecurityTokenVerifier.verificar(id);
	}
}
