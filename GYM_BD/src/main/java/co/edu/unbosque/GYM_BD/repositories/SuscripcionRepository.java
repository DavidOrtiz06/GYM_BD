package co.edu.unbosque.GYM_BD.repositories;

import co.edu.unbosque.GYM_BD.model.entities.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion, Integer> {

    @Query(value = """
    SELECT c.NOMBRE_CLIENTE, 
           c.CORREO_CLIENTE,
           s.FECHA_FIN_SUSCRIPCION
    FROM cliente c
    JOIN suscripcion s 
        ON c.ID_SUSCRIPCION = s.ID_SUSCRIPCION
    WHERE s.ESTADO_SUSCRIPCION = 'Activa'
        AND s.FECHA_FIN_SUSCRIPCION > CURDATE()
    """, nativeQuery = true)
    List<Object[]> obtenerSuscripcionesVigentes();

    @Query(value = """
    SELECT c.NUM_DOC_CLIENTE, 
           c.NOMBRE_CLIENTE
    FROM cliente c
    LEFT JOIN suscripcion s 
        ON c.ID_SUSCRIPCION = s.ID_SUSCRIPCION
    WHERE s.ESTADO_SUSCRIPCION <> 'Activa'
    """, nativeQuery = true)
    List<Object[]> obtenerClientesSinSuscripcionActiva();
}
