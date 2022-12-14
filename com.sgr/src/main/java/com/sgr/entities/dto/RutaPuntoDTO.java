package com.sgr.entities.dto;

import com.sgr.entities.PuntoMapa;
import com.sgr.entities.google.GoogleDistance;
import com.sgr.entities.google.GoogleDuration;
import lombok.Data;

@Data
public class RutaPuntoDTO {

    private long _id;
    private PuntoMapa punto;
    private String estado;
    private double distancia;
    private String tiempoTrabajo;
    private String tiempoTraslado;
}
