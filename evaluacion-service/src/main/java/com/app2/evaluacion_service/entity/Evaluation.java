package com.app2.evaluacion_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int prestamoId; // Referencia a Loan
    private String resultado; // e.g., "Aprobado", "Rechazado"
    private double relacionCuotaIngreso;
    private double relacionDeudaIngreso;
    private boolean esMoroso;
    private int edadFinal;
    private double saldoAhorros;
    private String comentarios;
    private LocalDateTime fechaEvaluacion;
}

