package com.app2.simulacion_service.controller;

import com.app2.simulacion_service.entity.SimulationLog;
import com.app2.simulacion_service.service.SimulationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/simulations")
public class SimulationLogController {

    @Autowired
    private SimulationLogService simulationLogService;

    /**
     * Endpoint para realizar una simulación.
     *
     * @param simulationRequest Objeto que contiene los datos de la simulación.
     * @return SimulationLog con los detalles de la simulación realizada.
     */
    @PostMapping
    public ResponseEntity<SimulationLog> realizarSimulacion(
            @RequestBody SimulationRequest simulationRequest) {
        // Llama al servicio usando los datos del cuerpo de la solicitud
        SimulationLog simulationLog = simulationLogService.realizarSimulacion(
                simulationRequest.getTipoPrestamo(),
                simulationRequest.getMonto(),
                simulationRequest.getPlazo(),
                simulationRequest.getTasaInteres()
        );
        return ResponseEntity.ok(simulationLog);
    }

    /**
     * Endpoint para obtener todas las simulaciones registradas.
     *
     * @return Lista de SimulationLog.
     */
    @GetMapping
    public ResponseEntity<List<SimulationLog>> obtenerTodasLasSimulaciones() {
        List<SimulationLog> simulationLogs = simulationLogService.obtenerTodasLasSimulaciones();
        return ResponseEntity.ok(simulationLogs);
    }

    /**
     * Clase interna que representa el cuerpo de la solicitud para realizar una simulación.
     */
    public static class SimulationRequest {
        private String tipoPrestamo;
        private double monto;
        private int plazo;
        private Double tasaInteres;

        // Getters y Setters
        public String getTipoPrestamo() {
            return tipoPrestamo;
        }

        public void setTipoPrestamo(String tipoPrestamo) {
            this.tipoPrestamo = tipoPrestamo;
        }

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }

        public int getPlazo() {
            return plazo;
        }

        public void setPlazo(int plazo) {
            this.plazo = plazo;
        }

        public Double getTasaInteres() {
            return tasaInteres;
        }

        public void setTasaInteres(Double tasaInteres) {
            this.tasaInteres = tasaInteres;
        }
    }
}