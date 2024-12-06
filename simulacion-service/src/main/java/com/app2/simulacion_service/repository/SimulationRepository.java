package com.app2.simulacion_service.repository;

import com.app2.simulacion_service.entity.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationRepository extends JpaRepository<Simulation, Integer> {
    // Métodos personalizados pueden ir aquí, como:
    // List<Simulation> findByUsuarioId(int usuarioId);
}

