package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

//Annotations
@Data
@AllArgsConstructor
@Document(collection = "Usuario")
public class Usuario {
	@Id
	private Long _id;
	private String username;
	private String apiId;
	private Rol rol;
	private String nombre;
	private String apellido;
	private String documento;
	private String telefono;
	private String email;
	private String direccion;
	//private Provider provider;
}
