package com.sgr.entities.dto;

import com.sgr.entities.RutaPunto;
import com.sgr.entities.Usuario;
import com.sgr.entities.Vehiculo;
import com.sgr.entities.google.GoogleBound;
import lombok.Data;

import java.util.List;
@Data
public class RutaDTO {
    private int _id;
    private String nombre;
    private Vehiculo vehiculo;
    private Usuario chofer;
    private Usuario administrador;
    private GoogleBound bound;
    private List<RutaPunto> puntos;
}
