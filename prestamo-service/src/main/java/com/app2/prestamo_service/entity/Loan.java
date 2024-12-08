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
    private String rut; // Referencia al usuario mediante el RUT
    private String tipoPrestamo; // Primera Vivienda, Segunda Vivienda, etc.
    private double monto;
    private int plazo; // En años
    private double tasaInteres;
    private double valorPropiedad;
    private String estado; // Estado del préstamo
    private boolean comprobanteIngreso; // Documento entregado físicamente
    private boolean certificadoAvaluo;  // Documento entregado físicamente
    private LocalDateTime fechaSolicitud;
}
