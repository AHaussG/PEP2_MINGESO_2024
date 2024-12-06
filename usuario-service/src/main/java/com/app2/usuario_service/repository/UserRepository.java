package com.app2.usuario_service.repository;

import com.app2.usuario_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Aquí puedes agregar métodos personalizados si los necesitas, por ejemplo:
    // List<User> findByNombre(String nombre);
}

