package com.app2.evaluacion_service.controller;

import com.app2.evaluacion_service.entity.Evaluation;
import com.app2.evaluacion_service.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping
    public ResponseEntity<List<Evaluation>> getAllEvaluations() {
        return ResponseEntity.ok(evaluationService.getAllEvaluations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable int id) {
        Evaluation evaluation = evaluationService.getEvaluationById(id);
        return evaluation != null ? ResponseEntity.ok(evaluation) : ResponseEntity.notFound().build();
    }

    @GetMapping("/loan/{prestamoId}")
    public ResponseEntity<List<Evaluation>> getEvaluationsByPrestamoId(@PathVariable int prestamoId) {
        List<Evaluation> evaluations = evaluationService.getEvaluationsByPrestamoId(prestamoId);
        return ResponseEntity.ok(evaluations);
    }

    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation newEvaluation = evaluationService.createEvaluation(evaluation);
        return ResponseEntity.ok(newEvaluation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable int id, @RequestBody Evaluation evaluationDetails) {
        Evaluation updatedEvaluation = evaluationService.updateEvaluation(id, evaluationDetails);
        return updatedEvaluation != null ? ResponseEntity.ok(updatedEvaluation) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable int id) {
        evaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
