package com.sgr.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("TipoDeResiduo")
public class TipoDeResiduo {

	private Long _id;
	@Indexed(unique = true)
	private String nombre;

}
