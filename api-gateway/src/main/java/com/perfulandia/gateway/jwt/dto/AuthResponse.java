package com.perfulandia.gateway.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO para controlar la respuesta tras autenticar
// con TOKEN JWT, nombre usuario y rol

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String username;
    private String rol;
}
