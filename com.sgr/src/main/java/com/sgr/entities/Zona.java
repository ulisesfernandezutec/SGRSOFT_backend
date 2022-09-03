package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NonNull;

@Data 
@Document("Zonas")
public class Zona {
	@Id
	private String id;
	private String nombre;
	private String coordenadas;
}
