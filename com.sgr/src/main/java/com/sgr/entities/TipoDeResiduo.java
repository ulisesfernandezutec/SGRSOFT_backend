package com.sgr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;


@Data
@Document("TipoDeResiduo")
public class TipoDeResiduo {
	@Id
	private Long id;
	private String nombre;

}
