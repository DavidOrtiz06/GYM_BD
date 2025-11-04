-- Contiene tabla e inserciones de horario

CREATE TABLE horario (
    ID_HORARIO INT AUTO_INCREMENT PRIMARY KEY,
    DIA VARCHAR(20) NOT NULL,
    HORA_INICIO TIME NOT NULL,
    HORA_FIN TIME NOT NULL,
    CUPO_HORARIO INT NOT NULL,
    ID_CLASE INT NOT NULL,
    FOREIGN KEY (ID_CLASE) REFERENCES clase(ID_CLASE)
);

INSERT INTO horario (
    DIA, HORA_INICIO, HORA_FIN, ID_CLASE, CUPO_HORARIO
) VALUES
('Lunes', '08:00', '08:30', 1, 30),
('Martes', '10:00', '11:00', 2, 25),
('Miércoles', '12:00', '12:45', 3, 15),
('Jueves', '12:00', '13:00', 2, 1),
('Viernes', '08:00', '08:30', 1, 20),
('Sabado', '10:00', '11:00', 2, 50),
('Lunes', '12:00', '12:45', 3, 45),
('Sabado', '12:00', '13:00', 2, 15);
