package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document("PuntosDR")
@AllArgsConstructor
public class PuntoDR {

	private Long _id;
	private Long tipoDeResiduo;
	private Long usuario;
	private String Coordenadas;

}
