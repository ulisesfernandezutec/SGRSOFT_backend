package com.sgr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuntoSalida {

    @Id
    private long _id;
    private double latitud;
    private double longitud;
    private String direccion;
    private String descripcion;
    private boolean enRuta;

}
