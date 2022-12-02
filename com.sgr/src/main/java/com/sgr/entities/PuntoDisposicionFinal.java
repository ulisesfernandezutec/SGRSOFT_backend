package com.sgr.entities;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuntoDisposicionFinal {
    @Id
    private long _id;
    private double latitud;
    private double longitud;
    private String direccion;
    private String descripcion;
    @Nullable
    boolean enRuta;
    private List<TipoDeResiduo> tipos;

}
