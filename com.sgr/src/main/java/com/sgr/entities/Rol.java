package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

//Annotations
@Data
@AllArgsConstructor
@Document(collection = "Rol")
public class Rol {
	
	@Id
	private long _id;
	@Indexed(unique = true)
	private String nombre;

}
