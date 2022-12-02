package com.sgr.entities.dto;
import lombok.Data;

@Data
public class PuntoSalidaDTO {
    private int _id;
    private double latitud;
    private double longitud;
    private String direccion;
    private String descripcion;
    private boolean enRuta;
}
