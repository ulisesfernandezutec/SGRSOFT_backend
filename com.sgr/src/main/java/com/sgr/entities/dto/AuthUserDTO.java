package com.sgr.entities.dto;

import com.sgr.entities.Rol;
import lombok.Data;

@Data
public class AuthUserDTO {

    private String token;
    private String email;
    private Rol rol;
    private String login;
}
