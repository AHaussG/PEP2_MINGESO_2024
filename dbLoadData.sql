USE ahaussdb;

-- Poblar la tabla users
INSERT INTO users (nombre, email, telefono, ingreso_mensual)
VALUES 
('Juan Pérez', 'juan.perez@example.com', '123456789', 2500.00),
('Ana López', 'ana.lopez@example.com', '987654321', 3000.00),
('Carlos Rivera', 'carlos.rivera@example.com', '112233445', 4000.00),
('María Fernández', 'maria.fernandez@example.com', '998877665', 3500.00),
('Luis Torres', 'luis.torres@example.com', '778899001', 2800.00);

-- Poblar la tabla simulations
INSERT INTO simulations (usuario_id, monto, plazo, tasa_interes, cuota_mensual, fecha_simulacion)
VALUES
(1, 100000, 20, 3.5, 579.96, NOW()),
(2, 150000, 25, 4.0, 791.76, NOW()),
(3, 200000, 30, 3.8, 932.20, NOW()),
(4, 120000, 15, 3.6, 857.45, NOW()),
(5, 180000, 20, 4.2, 1098.32, NOW());

-- Poblar la tabla loans
INSERT INTO loans (usuario_id, tipo_prestamo, monto, plazo, tasa_interes, valor_propiedad, estado, fecha_solicitud)
VALUES
(1, 'Primera Vivienda', 100000, 20, 3.5, 150000, 'Aprobado', NOW()),
(2, 'Segunda Vivienda', 150000, 25, 4.0, 200000, 'En Revisión', NOW()),
(3, 'Propiedad Comercial', 200000, 30, 3.8, 250000, 'Aprobado', NOW()),
(4, 'Remodelación', 120000, 15, 3.6, 170000, 'Pendiente de Documentación', NOW()),
(5, 'Primera Vivienda', 180000, 20, 4.2, 230000, 'Rechazado', NOW());

-- Poblar la tabla evaluations
INSERT INTO evaluations (prestamo_id, resultado, relacion_cuota_ingreso, relacion_deuda_ingreso, es_moroso, edad_final, saldo_ahorros, comentarios, fecha_evaluacion)
VALUES
(1, 'Aprobado', 25.00, 15.00, 0, 45, 10000.00, 'Evaluación exitosa', NOW()),
(2, 'Rechazado', 40.00, 25.00, 1, 50, 5000.00, 'Ingreso insuficiente', NOW()),
(3, 'Aprobado', 30.00, 20.00, 0, 55, 20000.00, 'Estabilidad financiera comprobada', NOW()),
(4, 'Rechazado', 35.00, 18.00, 0, 40, 15000.00, 'Falta documentación', NOW()),
(5, 'Rechazado', 50.00, 35.00, 1, 60, 3000.00, 'Historial crediticio negativo', NOW());

-- Poblar la tabla trackings
INSERT INTO trackings (prestamo_id, estado, fecha_estado)
VALUES
(1, 'En Revisión', NOW()),
(1, 'Aprobado', NOW()),
(2, 'En Revisión', NOW()),
(3, 'Aprobado', NOW()),
(4, 'Pendiente de Documentación', NOW());
