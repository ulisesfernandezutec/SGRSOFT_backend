package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document("Usuarios")
public class Usuario {
	
	@Id
	private String id;
	private String usuario;
	private String contraseña;

}
