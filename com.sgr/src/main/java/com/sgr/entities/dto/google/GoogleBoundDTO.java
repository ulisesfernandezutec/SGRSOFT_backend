package com.sgr.entities.dto.google;

import com.sgr.entities.google.GoogleLocation;
import lombok.Data;

@Data
public class GoogleBoundDTO {
    private long id;
    private GoogleLocation northeast;
    private GoogleLocation southwest;
}
