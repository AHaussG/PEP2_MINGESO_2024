package com.app2.usuario_service.repository;

import com.app2.usuario_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNombreAndRut(String nombre, String rut);
}
