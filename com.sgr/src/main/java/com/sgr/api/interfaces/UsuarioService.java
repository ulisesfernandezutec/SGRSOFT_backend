package com.sgr.api.interfaces;

import java.util.List;
import java.util.Optional;

import com.sgr.entities.Usuario;

public interface UsuarioService {
	
	Usuario create(Usuario usuario);

	Usuario update(Usuario usuario);
	
	Usuario getById(Long id);

	boolean delete(Long id);
    
    List < Usuario > list();

    Optional<Usuario> findByEmailLike(String email);
    
    Optional<Usuario> findFirstByUsernameLike(String username);
    
}
