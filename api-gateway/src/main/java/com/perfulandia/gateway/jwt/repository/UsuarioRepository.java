package com.perfulandia.gateway.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.gateway.jwt.model.Usuario;

// Capa de acceso a datos [DAO]
// Se extiende las operaciones CRUD
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Metodo - buscar un usuario por su Nombre
    // Optional : evita el null, se necesita de una excepcion
    Optional <Usuario> findByNombreUsuario(String nombreUsuario);

}
