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
@Document(collection = "Rol")
public class Rol {
	
	@Id
	private long _id;
	@Indexed(unique = true)
	private String nombre;

}
