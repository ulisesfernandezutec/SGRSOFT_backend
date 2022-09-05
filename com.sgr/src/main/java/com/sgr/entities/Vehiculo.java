package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;


@Data
@Document("Vehiculos")
public class Vehiculo {
	
	@Id
	private Long id;
	private String nombre;
	private String matricula;
	private String marca;
	private String modelo;
	private Persona chofer;

}
