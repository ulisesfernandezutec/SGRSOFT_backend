package com.sgr.entities;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

//Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PuntoRecoleccionEstado")
public class PuntoRecoleccionEstado {
	
	@Id
	private long _id;
	private String fecha;
	private long usuario;
	private String estado;
	private String detalle;

}
