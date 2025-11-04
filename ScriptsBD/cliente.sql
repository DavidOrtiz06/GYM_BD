-- Contiene tabla e inserciones de cliente

CREATE TABLE cliente (
    NUM_DOC_CLIENTE VARCHAR(15) PRIMARY KEY,
    NOMBRE_CLIENTE VARCHAR(100) NOT NULL,
    CORREO_CLIENTE VARCHAR(100) NOT NULL,
    ESTADO_CLIENTE VARCHAR(20) NOT NULL,
    NUM_TELEFONO_CLIENTE VARCHAR(15) NOT NULL,
    ID_SUSCRIPCION INT NOT NULL,
    FOREIGN KEY (ID_SUSCRIPCION) REFERENCES suscripcion(ID_SUSCRIPCION)
);

INSERT INTO cliente (
    NUM_DOC_CLIENTE, NOMBRE_CLIENTE, CORREO_CLIENTE,
    ESTADO_CLIENTE, NUM_TELEFONO_CLIENTE, ID_SUSCRIPCION
) VALUES
(1234950145, 'María Pérez', 'maria.perez@gmail.com', 'Inactivo', 3201234567, 1),
(1001671348, 'Pedro Rojas', 'pedro.rojas@gmail.com', 'Activo', 3153216547, 2),
(1001780210, 'Ana Torres', 'ana.torres@gmail.com', 'Inactivo', 3172589630, 3),
(1001890456, 'Lucía Vargas', 'lucia.vargas@gmail.com', 'Activo', 3214771521, 4),
(1001900789, 'Carlos Méndez', 'carlos.mendez@gmail.com', 'Activo', 3114569870, 5),
(1002011345, 'Sofía Martínez', 'sofia.martinez@gmail.com', 'Activo', 3108765432, 6),
(1002123456, 'Daniel Reyes', 'daniel.reyes@gmail.com', 'Activo', 3193456789, 7),
(1002234567, 'Valentina Soto', 'valentina.soto@gmail.com', 'Activo', 3124567890, 8),
(1002345678, 'Andrés Quintero', 'andres.quintero@gmail.com', 'Activo', 3159876543, 9),
(1002456789, 'Camila Ramírez', 'camila.ramirez@gmail.com', 'Inactivo', 3167654321, 10);
