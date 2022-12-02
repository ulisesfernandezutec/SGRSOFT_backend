package com.sgr.entities.dto;

import lombok.Data;
@Data
public class VehiculoDTO {
        private Long _id;
        private String nombre;
        private String matricula;
        private String marca;
        private String modelo;
        private Long chofer;
}
