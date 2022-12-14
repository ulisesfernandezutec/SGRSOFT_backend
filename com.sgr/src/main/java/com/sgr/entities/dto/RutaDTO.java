package com.sgr.entities.dto;

import com.google.api.client.util.DateTime;
import com.sgr.entities.*;
import com.sgr.entities.google.GoogleBound;
import lombok.Data;

import java.util.List;
@Data
public class RutaDTO {
    private long _id;
    private String nombre;
    private Vehiculo vehiculo;
    private Usuario chofer;
    private Usuario administrador;
    private GoogleBound bound;
    private List<RutaPunto> puntos;
    PuntoSalida salida;
    PuntoDisposicionFinal disposicionFinal;
    private long fecha;
    private String estado;
    private Double distancia;
    private Double tiempoTrabajo;
    private Double tiempoTraslado;

}
