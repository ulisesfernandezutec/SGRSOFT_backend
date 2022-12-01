package com.sgr.entities;

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
    private List<RutaPunto> puntos;
}
