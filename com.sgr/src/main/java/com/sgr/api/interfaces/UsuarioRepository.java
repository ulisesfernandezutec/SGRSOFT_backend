package com.sgr.api.interfaces;

import java.util.List;
import java.util.Optional;

import com.sgr.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsuarioRepository extends MongoRepository <Usuario, Long >{

	 @Query("{ 'email' : ?0 }")
	 Optional<Usuario> findByEmailLike(String email);

	 Optional<Usuario> findFirstByUsernameLike(String username);
}
