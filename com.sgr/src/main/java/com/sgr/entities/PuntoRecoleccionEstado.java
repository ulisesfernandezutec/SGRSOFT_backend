package com.sgr.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

//Annotations
@Data
@AllArgsConstructor
@Document(collection = "PuntoRecoleccionEstado")
public class PuntoRecoleccionEstado {
	
	@Id
	private long _id;
	private String fecha;
	private long usuario;
	private String estado;
	private String detalle;

}
