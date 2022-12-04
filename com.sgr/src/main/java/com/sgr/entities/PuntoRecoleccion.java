package com.sgr.entities;

import java.util.List;

import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document("PuntoRecoleccion")
@AllArgsConstructor
@NoArgsConstructor
public class PuntoRecoleccion {

	private long _id;
	private TipoDeResiduo tipo;
	private Long usuario;
	private double latitud;
	private double longitud;
	private String direccion;
	private String descripcion;
	private List<PuntoRecoleccionEstado> estados;


}
