package com.sgr.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document("PuntosDR")
@AllArgsConstructor
public class PuntoDR {

	private Long _id;
	private Long tipoDeResiduo;
	private Long usuario;
	private float latitud;
	private float longitud;

}
