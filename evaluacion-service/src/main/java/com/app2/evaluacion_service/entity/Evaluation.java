package com.app2.evaluacion_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evaluations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int prestamoId; // Relación con Loan

    @Column(nullable = false)
    private String resultado; // Resultado de la evaluación ("Aprobado", "Rechazado")

    private double relacionCuotaIngreso; // Porcentaje cuota/ingreso
    private double relacionDeudaIngreso; // Porcentaje deuda/ingreso
    private boolean esMoroso; // Indicador de morosidad
    private int edadFinal; // Edad al final del préstamo
    private double saldoAhorros; // Saldo de ahorros
    private String comentarios; // Comentarios adicionales

    @Column(nullable = false)
    private LocalDateTime fechaEvaluacion; // Fecha de evaluación
}
