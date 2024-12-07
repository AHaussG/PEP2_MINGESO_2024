package com.app2.simulacion_service.controller;

import com.app2.simulacion_service.entity.SimulationLog;
import com.app2.simulacion_service.service.SimulationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/simulations")
public class SimulationLogController {

    @Autowired
    private SimulationLogService simulationLogService;

    /**
     * Endpoint para realizar una simulación.
     *
     * @param tipoPrestamo Tipo de préstamo (Primera Vivienda, Segunda Vivienda, etc.)
     * @param monto Monto del préstamo
     * @param plazo Plazo en años
     * @param tasaInteres Tasa de interés anual
     * @return Registro de la simulación realizada
     */
    @PostMapping
    public ResponseEntity<SimulationLog> realizarSimulacion(
            @RequestParam String tipoPrestamo,
            @RequestParam double monto,
            @RequestParam int plazo,
            @RequestParam double tasaInteres) {
        SimulationLog simulationLog = simulationLogService.realizarSimulacion(tipoPrestamo, monto, plazo, tasaInteres);
        return ResponseEntity.ok(simulationLog);
    }

    /**
     * Endpoint para obtener todas las simulaciones realizadas.
     *
     * @return Lista de simulaciones
     */
    @GetMapping
    public ResponseEntity<List<SimulationLog>> obtenerSimulaciones() {
        List<SimulationLog> simulations = simulationLogService.obtenerTodasLasSimulaciones();
        return ResponseEntity.ok(simulations);
    }
}
