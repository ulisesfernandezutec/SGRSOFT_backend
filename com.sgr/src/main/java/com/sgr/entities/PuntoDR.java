package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document("PuntosDR")
public class PuntoDR {

	@Id
	private String id;
	private String zona;
	private TipoDeResiduo tipoDeResiduo;
	private Usuario usuario;

}
