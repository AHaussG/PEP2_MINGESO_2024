DROP DATABASE IF EXISTS ahaussdb;
CREATE DATABASE IF NOT EXISTS ahaussdb;
USE ahaussdb;

-- Tabla: users
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL COMMENT 'Nombre completo del usuario',
    email VARCHAR(100) UNIQUE NOT NULL COMMENT 'Correo electrónico del usuario',
    telefono VARCHAR(15) COMMENT 'Número de teléfono del usuario',
    ingreso_mensual DECIMAL(10,2) COMMENT 'Ingreso mensual del usuario',
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de registro del usuario'
);

-- Tabla: simulations
CREATE TABLE simulations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL COMMENT 'Referencia al usuario que realizó la simulación',
    monto DECIMAL(15,2) NOT NULL COMMENT 'Monto del préstamo simulado',
    plazo INT NOT NULL COMMENT 'Plazo del préstamo en años',
    tasa_interes DECIMAL(5,2) NOT NULL COMMENT 'Tasa de interés anual',
    cuota_mensual DECIMAL(15,2) NOT NULL COMMENT 'Cuota mensual calculada',
    fecha_simulacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de la simulación',
    FOREIGN KEY (usuario_id) REFERENCES users(id)
);

-- Tabla: loans
CREATE TABLE loans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL COMMENT 'Referencia al usuario que solicitó el préstamo',
    tipo_prestamo ENUM('Primera Vivienda', 'Segunda Vivienda', 'Propiedad Comercial', 'Remodelación') NOT NULL COMMENT 'Tipo de préstamo solicitado',
    monto DECIMAL(15,2) NOT NULL COMMENT 'Monto solicitado',
    plazo INT NOT NULL COMMENT 'Plazo del préstamo en años',
    tasa_interes DECIMAL(5,2) NOT NULL COMMENT 'Tasa de interés anual',
    valor_propiedad DECIMAL(15,2) NOT NULL COMMENT 'Valor de la propiedad asociada al préstamo',
    estado ENUM('En Revisión', 'Aprobado', 'Rechazado', 'Cancelado', 'Pendiente de Documentación') DEFAULT 'En Revisión' COMMENT 'Estado actual del préstamo',
    fecha_solicitud TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de la solicitud del préstamo',
    FOREIGN KEY (usuario_id) REFERENCES users(id)
);

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
    fecha_evaluacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de la evaluación',
    FOREIGN KEY (prestamo_id) REFERENCES loans(id)
);

-- Tabla: trackings
CREATE TABLE trackings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prestamo_id INT NOT NULL COMMENT 'Referencia al préstamo en seguimiento',
    estado ENUM('En Revisión', 'Pendiente de Documentación', 'En Evaluación', 'Aprobado', 'Rechazado') NOT NULL COMMENT 'Estado actual del préstamo',
    fecha_estado TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de actualización del estado',
    FOREIGN KEY (prestamo_id) REFERENCES loans(id)
);
