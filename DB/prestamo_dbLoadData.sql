USE prestamo_db;

-- Poblar la tabla loans
INSERT INTO loans (rut, tipo_prestamo, monto, plazo, tasa_interes, valor_propiedad, comprobante_ingreso, certificado_avaluo, estado, fecha_solicitud)
VALUES
('12345678-9', 'Primera Vivienda', 100000, 20, 3.5, 150000, 1, 1, 'Aprobado', NOW()),
('23456789-0', 'Segunda Vivienda', 150000, 25, 4.0, 200000, 1, 1, 'En Revisión', NOW()),
('34567890-1', 'Propiedades Comerciales', 200000, 30, 3.8, 250000, 1, 1, 'Aprobado', NOW()),
('45678901-2', 'Remodelación', 120000, 15, 3.6, 170000, 1, 1, 'Pendiente de Documentación', NOW()),
('56789012-3', 'Primera Vivienda', 180000, 20, 4.2, 230000, 1, 1, 'Rechazado', NOW());
