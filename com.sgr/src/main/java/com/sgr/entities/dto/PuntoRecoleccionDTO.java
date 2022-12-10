package com.sgr.entities.dto;

import com.sgr.entities.PuntoRecoleccionEstado;
import com.sgr.entities.TipoDeResiduo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class PuntoRecoleccionDTO {

    private Long _id;
    private TipoDeResiduo tipo;
    private Long usuario;
    private float latitud;
    private float longitud;
    private String direccion;
    private String descripcion;
    private List<PuntoRecoleccionEstado> estados;
}
