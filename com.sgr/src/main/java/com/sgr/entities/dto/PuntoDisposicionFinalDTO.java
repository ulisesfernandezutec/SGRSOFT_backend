package com.sgr.entities.dto;

import com.mongodb.lang.Nullable;
import com.sgr.entities.TipoDeResiduo;
import lombok.Data;

import java.util.List;
@Data
public class PuntoDisposicionFinalDTO {

    private long id;
    private double latitud;
    private double longitud;
    private String direccion;
    private String descripcion;
    @Nullable
    boolean enRuta;
    private List<TipoDeResiduo> tipos;
}
