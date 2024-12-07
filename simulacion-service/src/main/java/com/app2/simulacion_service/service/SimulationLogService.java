package com.app2.simulacion_service.service;

import com.app2.simulacion_service.entity.SimulationLog;
import com.app2.simulacion_service.repository.SimulationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationLogService {

    @Autowired
    private SimulationLogRepository simulationLogRepository;

    public double calcularCuotaMensual(double monto, int plazo, double tasaInteres) {
        double tasaMensual = tasaInteres / 100 / 12;
        int numeroCuotas = plazo * 12;
        return (monto * tasaMensual * Math.pow(1 + tasaMensual, numeroCuotas)) /
                (Math.pow(1 + tasaMensual, numeroCuotas) - 1);
    }

    public SimulationLog realizarSimulacion(String tipoPrestamo, double monto, int plazo, double tasaInteres) {
        validarTasaInteres(tipoPrestamo, tasaInteres);

        double cuotaMensual = calcularCuotaMensual(monto, plazo, tasaInteres);

        SimulationLog simulationLog = new SimulationLog();
        simulationLog.setTipoPrestamo(tipoPrestamo);
        simulationLog.setMonto(monto);
        simulationLog.setPlazo(plazo);
        simulationLog.setTasaInteres(tasaInteres);
        simulationLog.setCuotaMensual(cuotaMensual);
        simulationLog.setFecha(java.time.LocalDateTime.now());

        return simulationLogRepository.save(simulationLog);
    }

    private void validarTasaInteres(String tipoPrestamo, double tasaInteres) {
        switch (tipoPrestamo) {
            case "Primera Vivienda":
                if (tasaInteres < 3.5 || tasaInteres > 5.0) {
                    throw new IllegalArgumentException("La tasa de interés debe estar entre 3.5% y 5.0% para Primera Vivienda");
                }
                break;
            case "Segunda Vivienda":
                if (tasaInteres < 4.0 || tasaInteres > 6.0) {
                    throw new IllegalArgumentException("La tasa de interés debe estar entre 4.0% y 6.0% para Segunda Vivienda");
                }
                break;
            case "Propiedades Comerciales":
                if (tasaInteres < 5.0 || tasaInteres > 7.0) {
                    throw new IllegalArgumentException("La tasa de interés debe estar entre 5.0% y 7.0% para Propiedades Comerciales");
                }
                break;
            case "Remodelación":
                if (tasaInteres < 4.5 || tasaInteres > 6.0) {
                    throw new IllegalArgumentException("La tasa de interés debe estar entre 4.5% y 6.0% para Remodelación");
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo de préstamo no válido");
        }
    }

    public List<SimulationLog> obtenerTodasLasSimulaciones() {
        return simulationLogRepository.findAll();
    }
}
