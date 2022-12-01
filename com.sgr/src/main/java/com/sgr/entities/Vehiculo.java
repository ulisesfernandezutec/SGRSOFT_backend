package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Document("Vehiculos")
public class Vehiculo {
	@Id
	private Long _id;
	private String nombre;
	@Indexed(unique = true)
	private String matricula;
	private String marca;
	private String modelo;
	private Long chofer;

}
