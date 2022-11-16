package com.sgr.entities;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@Document("TipoDeResiduo")
public class TipoDeResiduo {

	private Long _id;
	@Indexed(unique = true)
	private String nombre;

}
