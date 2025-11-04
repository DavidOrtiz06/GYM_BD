-- Contiene tabla e inserciones de entrenador

CREATE TABLE entrenador (
    NUM_DOC_ENTRENADOR VARCHAR(15) PRIMARY KEY,
    NOMBRE_ENTRENADOR VARCHAR(100) NOT NULL,
    CORREO_ENTRENADOR VARCHAR(100) NOT NULL,
    ESTADO_ENTRENADOR VARCHAR(20) NOT NULL,
    NUM_TELEFONO_ENTRENADOR VARCHAR(15) NOT NULL,
    TURNO_ENTRENADOR VARCHAR(20) NOT NULL,
    ANIOS_EXP_ENTRENADOR INT,
    NIVEL_FORMACION_ENTRENADOR VARCHAR(50) NOT NULL
);

INSERT INTO entrenador (
    NUM_DOC_ENTRENADOR, NOMBRE_ENTRENADOR, CORREO_ENTRENADOR,
    ESTADO_ENTRENADOR, NUM_TELEFONO_ENTRENADOR,
    TURNO_ENTRENADOR, ANIOS_EXP_ENTRENADOR, NIVEL_FORMACION_ENTRENADOR
) VALUES
(1000948516, 'Carlos López', 'carlos.lopez@gymfit.com', 'Activo', 3104567890, 'Mañana', 5, 'Profesional'),
(1012987158, 'Laura Rincón', 'laura.rincon@gymfit.com', 'Activo', 3126547891, 'Mañana', 3, 'Tecnologo'),
(1002458796, 'Daniel Romero', 'daniel.romero@gymfit.com', 'Activo', 3108796543, 'Tarde', 6, 'Master'),
(1005674321, 'Camila Pérez', 'camila.perez@gymfit.com', 'Activo', 3147654321, 'Noche', 2, 'Tecnico'),
(1013456789, 'Andrés Vargas', 'andres.vargas@gymfit.com', 'Activo', 3139876543, 'Noche', 8, 'Especializacion');
