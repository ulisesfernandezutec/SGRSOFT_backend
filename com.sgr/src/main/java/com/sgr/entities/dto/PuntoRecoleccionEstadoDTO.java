package com.sgr.entities.dto;

import lombok.Data;
@Data
public class PuntoRecoleccionEstadoDTO {

    private long _id;
    private String fecha;
    private long usuario;
    private String estado;
    private String detalle;
}
