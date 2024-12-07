package com.app2.evaluacion_service.service;

import com.app2.evaluacion_service.entity.Evaluation;
import com.app2.evaluacion_service.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public Evaluation getEvaluationById(int id) {
        return evaluationRepository.findById(id).orElse(null);
    }

    public List<Evaluation> getEvaluationsByPrestamoId(int prestamoId) {
        return evaluationRepository.findByPrestamoId(prestamoId);
    }

    public Evaluation createEvaluation(Evaluation evaluation) {
        evaluation.setFechaEvaluacion(LocalDateTime.now()); // Establece la fecha actual
        return evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(int id, Evaluation evaluationDetails) {
        Evaluation evaluation = evaluationRepository.findById(id).orElse(null);
        if (evaluation != null) {
            evaluation.setResultado(evaluationDetails.getResultado());
            evaluation.setRelacionCuotaIngreso(evaluationDetails.getRelacionCuotaIngreso());
            evaluation.setRelacionDeudaIngreso(evaluationDetails.getRelacionDeudaIngreso());
            evaluation.setEsMoroso(evaluationDetails.isEsMoroso());
            evaluation.setEdadFinal(evaluationDetails.getEdadFinal());
            evaluation.setSaldoAhorros(evaluationDetails.getSaldoAhorros());
            evaluation.setComentarios(evaluationDetails.getComentarios());
            return evaluationRepository.save(evaluation);
        }
        return null;
    }

    public void deleteEvaluation(int id) {
        evaluationRepository.deleteById(id);
    }
}
