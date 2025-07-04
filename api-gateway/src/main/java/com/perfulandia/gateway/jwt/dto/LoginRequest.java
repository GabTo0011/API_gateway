package com.perfulandia.gateway.jwt.dto;

import lombok.Data;

//DTO estructura la solicitud de inicio de sesion
// con nombre de suario y contraseña

@Data
//@Data genera un constructor vacio que Spring usa para llenar
//@NoArgsConstructor 
public class LoginRequest {
    private String nombreUsuario;
    private String contrasena;
}
