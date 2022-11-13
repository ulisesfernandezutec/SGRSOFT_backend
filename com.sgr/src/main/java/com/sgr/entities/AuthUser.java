package com.sgr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {

 private String user;
 private String token;
 private String email;
 private Rol rol;
 private String login;
 
}
