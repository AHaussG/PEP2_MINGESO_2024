USE evaluacion_db;

-- Poblar la tabla evaluations
INSERT INTO evaluations (prestamo_id, resultado, relacion_cuota_ingreso, relacion_deuda_ingreso, es_moroso, edad_final, saldo_ahorros, comentarios, fecha_evaluacion)
VALUES
(1, 'Aprobado', 25.00, 15.00, 0, 45, 10000.00, 'Evaluación exitosa', NOW()),
(2, 'Rechazado', 40.00, 25.00, 1, 50, 5000.00, 'Ingreso insuficiente', NOW()),
(3, 'Aprobado', 30.00, 20.00, 0, 55, 20000.00, 'Estabilidad financiera comprobada', NOW()),
(4, 'Rechazado', 35.00, 18.00, 0, 40, 15000.00, 'Falta documentación', NOW()),
(5, 'Rechazado', 50.00, 35.00, 1, 60, 3000.00, 'Historial crediticio negativo', NOW());
