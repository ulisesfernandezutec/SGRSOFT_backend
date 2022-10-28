package com.sgr.api.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sgr.entities.Rol;

public interface RolRepository extends MongoRepository < Rol, Long > {

}
