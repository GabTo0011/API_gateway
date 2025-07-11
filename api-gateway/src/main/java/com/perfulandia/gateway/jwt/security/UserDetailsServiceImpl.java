package com.perfulandia.gateway.jwt.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.perfulandia.gateway.jwt.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository
            .findByNombreUsuario(username)
            .map(UserDetailsImpl::new)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"))
        ;
    }
}
