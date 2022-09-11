package com.sgr.entities;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@AllArgsConstructor
@Document("Usuarios")
public class Usuario {

	private Long _id;
	private String usuario;
	private String contraseña;

}
