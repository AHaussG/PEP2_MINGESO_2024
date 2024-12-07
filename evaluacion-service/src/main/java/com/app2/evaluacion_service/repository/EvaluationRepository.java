package com.app2.evaluacion_service.repository;

import com.app2.evaluacion_service.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
    List<Evaluation> findByPrestamoId(int prestamoId);
}
