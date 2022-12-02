package com.sgr.entities.dto;

import com.sgr.entities.PuntoMapa;
import com.sgr.entities.RutaPuntoEstado;
import com.sgr.entities.google.GoogleDistance;
import com.sgr.entities.google.GoogleDuration;
import lombok.Data;

@Data
public class RutaPuntoDTO {

    private int _id;
    private PuntoMapa punto;
    private GoogleDuration googleDuration;
    private GoogleDistance googleDistance;
    private RutaPuntoEstado estado;
}
