package com.app2.evaluacion_service.repository;

import com.app2.evaluacion_service.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
    // Métodos personalizados para búsqueda:
    // List<Evaluation> findByPrestamoId(int prestamoId);
}
