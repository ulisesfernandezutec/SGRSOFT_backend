package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@Document("Vehiculos")
public class Vehiculo {

	private Long _id;
	private String nombre;
	private String matricula;
	private String marca;
	private String modelo;
	private Long chofer;

}
