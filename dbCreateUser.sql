DROP DATABASE IF EXISTS usuario_db;
CREATE DATABASE IF NOT EXISTS usuario_db;
USE usuario_db;

-- Tabla: users
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL COMMENT 'Nombre completo del usuario',
    rut VARCHAR(12) UNIQUE NOT NULL COMMENT 'RUT del usuario',
    email VARCHAR(100) COMMENT 'Correo electrónico del usuario',
    telefono VARCHAR(15) COMMENT 'Número de teléfono del usuario',
    ingreso_mensual DECIMAL(10,2) COMMENT 'Ingreso mensual del usuario',
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de registro del usuario'
);
