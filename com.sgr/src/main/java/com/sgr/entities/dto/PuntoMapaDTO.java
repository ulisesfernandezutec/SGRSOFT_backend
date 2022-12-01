package com.sgr.entities.dto;

import lombok.Data;

@Data
public class PuntoMapaDTO {
    private int id;
    private double latitud;
    private double longitud;
    private String direccion;
    private String descripcion;
    boolean enRuta;

}
