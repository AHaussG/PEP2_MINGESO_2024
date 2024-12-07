USE prestamo_db;

-- Poblar la tabla loans
INSERT INTO loans (usuario_id, tipo_prestamo, monto, plazo, tasa_interes, valor_propiedad, comprobante_ingreso, certificado_avaluo, estado, fecha_solicitud)
VALUES
(1, 'Primera Vivienda', 100000, 20, 3.5, 150000, 1, 1, 'Aprobado', NOW()),
(2, 'Segunda Vivienda', 150000, 25, 4.0, 200000, 1, 0, 'En Revisión', NOW()),
(3, 'Propiedades Comerciales', 200000, 30, 3.8, 250000, 0, 1, 'Aprobado', NOW()),
(4, 'Remodelación', 120000, 15, 3.6, 170000, 1, 0, 'Pendiente de Documentación', NOW()),
(5, 'Primera Vivienda', 180000, 20, 4.2, 230000, 0, 0, 'Rechazado', NOW());
