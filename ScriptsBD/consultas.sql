-- Contiene todas las CONSULTAS SQL del gimnasio

-- Listar suscripciones vigentes con fecha de finalización posterior a la fecha actual
SELECT c.NOMBRE_CLIENTE, 
       c.CORREO_CLIENTE,
       s.FECHA_FIN_SUSCRIPCION
FROM cliente c
JOIN suscripcion s 
	ON c.ID_SUSCRIPCION = s.ID_SUSCRIPCION
WHERE s.ESTADO_SUSCRIPCION = 'Activa'
	AND s.FECHA_FIN_SUSCRIPCION > CURDATE();
  
-- Obtener los horarios de todas las clases de “Yoga”
SELECT h.DIA, 
	   h.HORA_INICIO, 
       h.HORA_FIN, 
       h.CUPO_HORARIO
FROM clase c
JOIN horario h 
	ON c.ID_CLASE = h.ID_CLASE
WHERE c.NOMBRE_CLASE = 'Yoga';

-- Mostrar los clientes inscritos en más de una clase
SELECT c.NUM_DOC_CLIENTE, 
       c.NOMBRE_CLIENTE, 
       COUNT(i.ID_CLASE) AS TOTAL_CLASES
FROM cliente c
JOIN ingreso i 
	ON c.NUM_DOC_CLIENTE = i.NUM_DOC_CLIENTE
GROUP BY c.NUM_DOC_CLIENTE, 
		 c.NOMBRE_CLIENTE
HAVING COUNT(i.ID_CLASE) > 1;

-- Obtener las valoraciones atendidas por fisioterapeutas en una fecha específica
SELECT v.FECHA_VALORACION, 
       v.HORA_VALORACION, 
       v.ESTADO_VALORACION, 
       f.NOMBRE_FISIOTERAPEUTA
FROM valoracion v
JOIN fisioterapeuta f 
	ON v.NUM_DOC_FISIOTERAPEUTA = f.NUM_DOC_FISIOTERAPEUTA
WHERE v.FECHA_VALORACION = '2025-11-06';

-- Listar los clientes que no tienen suscripción activa
SELECT c.NUM_DOC_CLIENTE, 
       c.NOMBRE_CLIENTE
FROM cliente c
LEFT JOIN suscripcion s 
	ON c.ID_SUSCRIPCION = s.ID_SUSCRIPCION
WHERE s.ESTADO_SUSCRIPCION <> 'Activa';

-- Listar las clases con cupo mayor a 20 y su duración
SELECT c.NOMBRE_CLASE, 
       c.DURACION_CLASE, 
       h.CUPO_HORARIO
FROM clase c
JOIN horario h 
	ON c.ID_CLASE = h.ID_CLASE
WHERE h.CUPO_HORARIO > 20;

-- Clases que duran más de 60 minutos y tienen menos de 15 cupos
SELECT c.NOMBRE_CLASE, 
       c.DURACION_CLASE, 
       h.CUPO_HORARIO
FROM clase c
JOIN horario h 
	ON c.ID_CLASE = h.ID_CLASE
WHERE CAST(c.DURACION_CLASE AS UNSIGNED) > 10
	AND h.CUPO_HORARIO < 25;

-- Valoraciones con estado “Pendiente” y la persona atendida
SELECT v.FECHA_VALORACION, 
       v.HORA_VALORACION, 
       v.ESTADO_VALORACION, 
       f.NOMBRE_FISIOTERAPEUTA, 
       c.NOMBRE_CLIENTE
FROM valoracion v
JOIN fisioterapeuta f 
	ON v.NUM_DOC_FISIOTERAPEUTA = f.NUM_DOC_FISIOTERAPEUTA
JOIN cliente c
	ON v.NUM_DOC_CLIENTE = c.NUM_DOC_CLIENTE
WHERE v.ESTADO_VALORACION = 'Pendiente';

-- Clientes atendidos por un fisioterapeuta específico
SELECT DISTINCT c.NUM_DOC_CLIENTE, 
				c.NOMBRE_CLIENTE
FROM cliente c
JOIN valoracion v 
	ON c.NUM_DOC_CLIENTE = v.NUM_DOC_CLIENTE
JOIN fisioterapeuta f 
	ON v.NUM_DOC_FISIOTERAPEUTA = f.NUM_DOC_FISIOTERAPEUTA
WHERE f.NUM_DOC_FISIOTERAPEUTA = '1012154853';

-- Entrenadores con turno de la mañana
SELECT NOMBRE_ENTRENADOR
FROM entrenador
WHERE TURNO_ENTRENADOR = 'Mañana';