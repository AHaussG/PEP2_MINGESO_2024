package com.app2.simulacion_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "simulation_logs") // Nombre de la tabla en la base de datos
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único de la simulación

    private String tipoPrestamo; // Tipo de préstamo ("Primera Vivienda", "Segunda Vivienda", etc.)
    private double monto; // Monto del préstamo
    private int plazo; // Plazo en años
    private double tasaInteres; // Tasa de interés anual
    private double cuotaMensual; // Cuota mensual calculada
    private LocalDateTime fecha; // Fecha de la simulación
}