DROP DATABASE IF EXISTS simulacion_db;
CREATE DATABASE IF NOT EXISTS simulacion_db;
USE simulacion_db;

-- Tabla: simulation_logs
CREATE TABLE simulation_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_prestamo ENUM('Primera Vivienda', 'Segunda Vivienda', 'Propiedades Comerciales', 'Remodelación') NOT NULL COMMENT 'Tipo de préstamo simulado',
    monto DECIMAL(15,2) NOT NULL COMMENT 'Monto del préstamo simulado',
    plazo INT NOT NULL COMMENT 'Plazo del préstamo en años',
    tasa_interes DECIMAL(5,2) NOT NULL COMMENT 'Tasa de interés anual',
    cuota_mensual DECIMAL(15,2) NOT NULL COMMENT 'Cuota mensual calculada',
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de la simulación'
);
