package com.sgr.api.interfaces;

import java.util.Optional;

import com.sgr.entities.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository < Usuario, Long > {
	

}
