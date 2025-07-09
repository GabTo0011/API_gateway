// define ubicacion paquete controlador 
package com.perfulandia.gateway.jwt.controller;

// Importa anotaciones para definir rutas y controladores REST
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importa DTOs y servicios para el login
import com.perfulandia.gateway.jwt.dto.AuthResponse;
import com.perfulandia.gateway.jwt.dto.LoginRequest;
import com.perfulandia.gateway.jwt.service.AuthService;

// Importa anotacion lombok
import lombok.RequiredArgsConstructor;

/**
 * controlador encargado de gestionar las solicitudes de autenticacion.
**/


@RestController // Define clase como controlador REST

// Define ruta base para endpoints de este controlador
@RequestMapping("/api/auth")

// Genera contructor con argumentos AuthController(AuthService authService)
@RequiredArgsConstructor
public class AuthController {

    // Inyeccion dependencia servicio de autenticacion
    private final  AuthService authService;

    // Define endpoint POST "/api/auth/login"
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){

        // llama al servicio de autenticacion con datos del usuario
        // (DTO LoginRequest como request)
        // Devuelve respuesta con TOKEN + info user
        // (DTO AuthResponse como response)
        return authService.login(request);
    }
}
