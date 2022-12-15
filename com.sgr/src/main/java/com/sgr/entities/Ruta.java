package com.sgr.entities;

import com.google.api.client.util.DateTime;
import com.sgr.entities.google.GoogleBound;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ruta {
    private long _id;
    private String nombre;
    private Vehiculo vehiculo;
    private Usuario chofer;
    private Usuario administrador;
    private GoogleBound bound;
    PuntoSalida salida;
    PuntoDisposicionFinal disposicionFinal;
    private List<RutaPunto> puntos;
    private String estado;
    private Double distancia;
    private Double tiempoTotal;
    private Double tiempoTrabajo;
    private Double tiempoTraslado;
    private long fecha;
    private boolean optimizada;
}
