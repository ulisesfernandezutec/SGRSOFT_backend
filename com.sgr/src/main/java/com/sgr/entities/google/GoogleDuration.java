package com.sgr.entities.google;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoogleDuration {
    @Id
    private long _id;
    private String text;
    private int value;
}
