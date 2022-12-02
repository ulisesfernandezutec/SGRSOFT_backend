package com.sgr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RutaPuntoEstado{
    @Id
    private long _id;
    private String nombre;
    private String descripcion;

}
