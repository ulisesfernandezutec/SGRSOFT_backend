package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;



//Annotations
@Data
@AllArgsConstructor
@Document(collection = "Personas")
public class Persona {
	@Id
	private Long _id;
	private String 	nombre;
	private String 	apellido;
	private String 	direccion;
	private String 	telefono;
	private String 	observaciones;
	private String 	otros;
	private String  usuario;
	private String  rol;
	private String  idautorización;
}
