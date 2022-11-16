package com.sgr.api.interfaces;

import java.util.List;
import java.util.Optional;

import com.sgr.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsuarioRepository extends MongoRepository <Usuario, Long >{

	 Optional<Usuario> findFirstByEmailLike(String email);

}
