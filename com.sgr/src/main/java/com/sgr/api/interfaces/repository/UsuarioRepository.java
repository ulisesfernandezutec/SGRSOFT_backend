package com.sgr.api.interfaces.repository;

import java.util.Optional;
import com.sgr.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository <Usuario, Long >{

	 Optional<Usuario> findFirstByEmailLike(String email);

	Optional<Usuario> findFirstByEstadoLike(String estado);

}
