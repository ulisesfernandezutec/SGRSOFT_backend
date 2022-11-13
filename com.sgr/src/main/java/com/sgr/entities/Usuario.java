package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Usuario {
	@Id
	private Long _id;
	@Indexed(unique = true)
	private String username;
	private String pwrd;
	private Rol rol;
	private String nombre;
	private String apellido;
	private String documento;
	private String telefono;
	@Indexed(unique = true)
	private String email;
	private String direccion;
	//private Provider provider;
}
