package com.app2.usuario_service.repository;

import com.app2.usuario_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Método existente para validar usuario por nombre y RUT
    Optional<User> findByNombreAndRut(String nombre, String rut);

    // Nuevo método para verificar existencia por RUT
    boolean existsByRut(String rut);
}
