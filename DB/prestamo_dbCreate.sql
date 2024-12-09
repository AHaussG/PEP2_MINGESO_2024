DROP DATABASE IF EXISTS prestamo_db;
CREATE DATABASE IF NOT EXISTS prestamo_db;
USE prestamo_db;

-- Tabla: loans
CREATE TABLE loans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rut VARCHAR(12) NOT NULL COMMENT 'Referencia al usuario mediante el RUT',
    tipo_prestamo ENUM('Primera Vivienda', 'Segunda Vivienda', 'Propiedades Comerciales', 'Remodelación') NOT NULL COMMENT 'Tipo de préstamo solicitado',
    monto DECIMAL(15,2) NOT NULL COMMENT 'Monto solicitado',
    plazo INT NOT NULL COMMENT 'Plazo del préstamo en años',
    tasa_interes DECIMAL(5,2) NOT NULL COMMENT 'Tasa de interés anual',
    valor_propiedad DECIMAL(15,2) NOT NULL COMMENT 'Valor de la propiedad asociada al préstamo',
    comprobante_ingreso BOOLEAN NOT NULL DEFAULT 0 COMMENT 'Indica si el comprobante de ingreso fue entregado',
    certificado_avaluo BOOLEAN NOT NULL DEFAULT 0 COMMENT 'Indica si el certificado de avalúo fue entregado',
    estado ENUM('En Revisión', 'Aprobado', 'Rechazado', 'Pendiente de Documentación') DEFAULT 'En Revisión' COMMENT 'Estado actual del préstamo',
    fecha_solicitud TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de la solicitud del préstamo'
);
