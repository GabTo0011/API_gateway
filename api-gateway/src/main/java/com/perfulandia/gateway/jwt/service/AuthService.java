package com.perfulandia.gateway.jwt.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.perfulandia.gateway.jwt.dto.AuthResponse;
import com.perfulandia.gateway.jwt.dto.LoginRequest;
import com.perfulandia.gateway.jwt.model.Usuario;
import com.perfulandia.gateway.jwt.repository.UsuarioRepository;
import com.perfulandia.gateway.jwt.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthResponse login(LoginRequest request){
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getNombreUsuario(), 
                request.getContrasena()
            )
        );

        Usuario usuario = 
            usuarioRepository
            .findByNombreUsuario(request.getNombreUsuario())
            .orElseThrow()
        ;

        if (!"activo".equalsIgnoreCase(usuario.getEstado())){
            throw new BadCredentialsException("Usuario inactivo");
        }

        String token = jwtUtil.generateToken(
            usuario.getNombreUsuario(),
            usuario.getRol()
        );

        return new AuthResponse(
            token, 
            usuario.getNombreUsuario(), 
            usuario.getRol()
        );
    }

}
