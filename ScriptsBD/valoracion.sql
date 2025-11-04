-- Contiene tabla e inserciones de valoracion

CREATE TABLE valoracion (
    ID_VALORACION INT AUTO_INCREMENT PRIMARY KEY,
    FECHA_VALORACION DATE NOT NULL,
    HORA_VALORACION TIME NOT NULL,
    ESTADO_VALORACION VARCHAR(20) NOT NULL,
    NUM_DOC_CLIENTE VARCHAR(15) NOT NULL,
    NUM_DOC_FISIOTERAPEUTA VARCHAR(15) NOT NULL,
    RESTRICCIONES VARCHAR(500),
    FOREIGN KEY (NUM_DOC_CLIENTE) REFERENCES cliente(NUM_DOC_CLIENTE),
    FOREIGN KEY (NUM_DOC_FISIOTERAPEUTA) REFERENCES fisioterapeuta(NUM_DOC_FISIOTERAPEUTA)
);	

INSERT INTO valoracion (
    FECHA_VALORACION, HORA_VALORACION,ESTADO_VALORACION, 
    NUM_DOC_CLIENTE, NUM_DOC_FISIOTERAPEUTA, RESTRICCIONES
) VALUES
('2025-11-06', '08:30', 'Pendiente', 1234950145, 1000154762, ''),
('2025-09-03', '09:00', 'Completada', 1001671348, 1000154762, 'No levantar peso superior a 10 kg durante una semana.'),
('2025-09-05', '10:30', 'Completada', 1001780210, 1012154853, 'Realizar estiramientos diarios y evitar posiciones forzadas.'),
('2025-11-02', '11:00', 'Completada', 1001890456, 1012154853, 'Sin restricciones.'),
('2025-10-15', '08:00', 'Completada', 1001900789, 1000154762, 'No correr durante 3 días.'),
('2025-09-22', '09:30', 'Completada', 1002011345, 1012154853, 'Evitar esfuerzo en espalda.'),
('2025-08-11', '14:00', 'Completada', 1002123456, 1012154853, 'Sin restricciones.'),
('2025-12-01', '13:00', 'Pendiente', 1002234567, 1000154762, ''),
('2025-12-05', '15:30', 'Pendiente', 1002345678, 1012154853, ''),
('2025-10-10', '09:30', 'Completada', 1002456789, 1000154762, 'Iniciar fisioterapia leve de rodilla.');
