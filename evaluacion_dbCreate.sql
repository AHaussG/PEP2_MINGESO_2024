DROP DATABASE IF EXISTS evaluacion_db;
CREATE DATABASE IF NOT EXISTS evaluacion_db;
USE evaluacion_db;

-- Tabla: evaluations
CREATE TABLE evaluations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prestamo_id INT NOT NULL COMMENT 'Referencia al préstamo evaluado',
    resultado ENUM('Aprobado', 'Rechazado') NOT NULL COMMENT 'Resultado de la evaluación',
    relacion_cuota_ingreso DECIMAL(5,2) COMMENT 'Porcentaje cuota/ingreso',
    relacion_deuda_ingreso DECIMAL(5,2) COMMENT 'Porcentaje deuda/ingreso',
    es_moroso BOOLEAN COMMENT 'Indica si el usuario tiene historial de morosidad',
    edad_final INT COMMENT 'Edad del usuario al finalizar el préstamo',
    saldo_ahorros DECIMAL(15,2) COMMENT 'Saldo de ahorros del usuario',
    comentarios TEXT COMMENT 'Comentarios adicionales sobre la evaluación',
    fecha_evaluacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de la evaluación'
);
