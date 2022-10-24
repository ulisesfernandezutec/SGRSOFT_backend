package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

//Annotations
@Data
@AllArgsConstructor
@Document(collection = "Rol")
public class Rol {
	
	@Id
	private long _id;
	private String nombre;

}
