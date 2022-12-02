package com.sgr.entities.google;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoogleBound {

    @Id
    long _id;
    private GoogleLocation northeast;
    private GoogleLocation southwest;
}
