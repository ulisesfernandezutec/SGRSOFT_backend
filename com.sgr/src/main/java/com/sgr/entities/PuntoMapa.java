package com.sgr.entities;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PuntoMapa {
    @Id
    private long _id;
    private double latitud;
    private double longitud;
    private String direccion;
    private String descripcion;
    @Nullable
    boolean enRuta;
}
