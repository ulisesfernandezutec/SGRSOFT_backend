package com.sgr.entities.dto;

import com.sgr.entities.Rol;
import lombok.Data;

@Data
public class UsuarioDTO {
    private Long _id;
    private String pwrd;
    private Rol rol;
    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String email;
    private String direccion;
    private String estado;
}