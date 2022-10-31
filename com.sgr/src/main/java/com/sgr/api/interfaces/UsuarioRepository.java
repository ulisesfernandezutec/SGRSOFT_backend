package com.sgr.api.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sgr.entities.Usuario;

public interface UsuarioRepository extends MongoRepository < Usuario, Long >{

}
