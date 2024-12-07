USE usuario_db;

-- Poblar la tabla users
INSERT INTO users (nombre, rut, email, telefono, ingreso_mensual, fecha_registro)
VALUES 
('Juan Pérez', '12345678-9', 'juan.perez@example.com', '123456789', 2500.00, NOW()),
('Ana López', '98765432-1', 'ana.lopez@example.com', '987654321', 3000.00, NOW()),
('Carlos Rivera', '11223344-5', 'carlos.rivera@example.com', '112233445', 4000.00, NOW()),
('María Fernández', '99887766-5', 'maria.fernandez@example.com', '998877665', 3500.00, NOW()),
('Luis Torres', '77889900-1', 'luis.torres@example.com', '778899001', 2800.00, NOW());
