package com.sgr.entities;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

//Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Usuario")
public class Usuario {
	@Id
	private Long _id;
	private String pwrd;
	private Rol rol;
	private String nombre;
	private String apellido;
	private String telefono;
	@Indexed(unique = true)
	private String email;
	private String direccion;
	private String estado;
}
