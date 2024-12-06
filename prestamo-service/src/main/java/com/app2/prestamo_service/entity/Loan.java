package com.app2.prestamo_service.entity;

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
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int usuarioId; // Referencia a User
    private String tipoPrestamo; // e.g., "Primera Vivienda", "Segunda Vivienda"
    private double monto;
    private int plazo;
    private double tasaInteres;
    private double valorPropiedad;
    private String estado; // e.g., "En Revisión", "Aprobado", etc.
    private LocalDateTime fechaSolicitud;
}

