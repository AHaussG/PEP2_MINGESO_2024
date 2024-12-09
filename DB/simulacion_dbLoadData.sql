USE simulacion_db;

-- Poblar la tabla simulation_logs
INSERT INTO simulation_logs (tipo_prestamo, monto, plazo, tasa_interes, cuota_mensual, fecha)
VALUES
('Primera Vivienda', 100000, 20, 3.5, 579.96, NOW()),
('Segunda Vivienda', 150000, 25, 4.0, 791.76, NOW()),
('Propiedades Comerciales', 200000, 30, 3.8, 932.20, NOW()),
('Remodelación', 120000, 15, 3.6, 857.45, NOW()),
('Primera Vivienda', 180000, 20, 4.2, 1098.32, NOW());
