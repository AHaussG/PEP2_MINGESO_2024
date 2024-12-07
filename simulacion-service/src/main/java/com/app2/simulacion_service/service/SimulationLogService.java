package com.app2.simulacion_service.service;

import com.app2.simulacion_service.entity.SimulationLog;
import com.app2.simulacion_service.repository.SimulationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SimulationLogService {

    @Autowired
    private SimulationLogRepository simulationLogRepository;

    // Crear una simulación
    public SimulationLog realizarSimulacion(String tipoPrestamo, double monto, int plazo, Double tasaInteres) {
        // Validar y asignar tasas de interés según tipo de préstamo
        if (tasaInteres == null) {
            switch (tipoPrestamo) {
                case "Primera Vivienda":
                    tasaInteres = 3.5 + Math.random() * (5.0 - 3.5);
                    break;
                case "Segunda Vivienda":
                    tasaInteres = 4.0 + Math.random() * (6.0 - 4.0);
                    break;
                case "Propiedades Comerciales":
                    tasaInteres = 5.0 + Math.random() * (7.0 - 5.0);
                    break;
                case "Remodelación":
                    tasaInteres = 4.5 + Math.random() * (6.0 - 4.5);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de préstamo no válido.");
            }
        }

        // Calcular la cuota mensual
        double tasaMensual = tasaInteres / 100 / 12;
        int plazoMeses = plazo * 12;
        double cuotaMensual = (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazoMeses));

        // Crear y guardar el registro de simulación
        SimulationLog simulationLog = new SimulationLog();
        simulationLog.setTipoPrestamo(tipoPrestamo);
        simulationLog.setMonto(monto);
        simulationLog.setPlazo(plazo);
        simulationLog.setTasaInteres(tasaInteres);
        simulationLog.setCuotaMensual(cuotaMensual);
        simulationLog.setFecha(LocalDateTime.now());

        return simulationLogRepository.save(simulationLog);
    }

    // Listar todas las simulaciones
    public List<SimulationLog> obtenerTodasLasSimulaciones() {
        return simulationLogRepository.findAll();
    }
}