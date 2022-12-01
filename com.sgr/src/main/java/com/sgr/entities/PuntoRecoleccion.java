package com.sgr.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document("PuntoRecoleccion")
@AllArgsConstructor
public class PuntoRecoleccion {

	private long _id;
	private TipoDeResiduo tipo;
	private Long usuario;
	private float latitud;
	private float longitud;
	private String direccion;
	private String descripcion;
	private List<PuntoRecoleccionEstado> estados;


}
