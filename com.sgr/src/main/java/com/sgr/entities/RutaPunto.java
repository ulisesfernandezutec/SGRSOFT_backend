package com.sgr.entities;

import com.sgr.entities.google.GoogleDistance;
import com.sgr.entities.google.GoogleDuration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RutaPunto {
    @Id
    private long _id;
    private PuntoMapa punto;
    private GoogleDuration googleDuration;
    private GoogleDistance googleDistance;
    private RutaPuntoEstado estado;
    private String tiempo_trabajo;
    private String tiempo_traslado;

}
