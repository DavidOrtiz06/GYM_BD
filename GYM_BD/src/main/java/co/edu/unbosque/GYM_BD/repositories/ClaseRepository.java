package co.edu.unbosque.GYM_BD.repositories;

import co.edu.unbosque.GYM_BD.model.entities.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer> {

    @Query(value = """
    SELECT c.NOMBRE_CLASE, 
           c.DURACION_CLASE,
           h.CUPO_HORARIO
    FROM clase c
    JOIN horario h 
        ON c.ID_CLASE = h.ID_CLASE
    WHERE h.CUPO_HORARIO > :cupo
    """, nativeQuery = true)
    List<Object[]> obtenerClasesConCupoMayorA(@Param("cupo") Integer cupo);

    @Query(value = """
    SELECT c.NOMBRE_CLASE,
           c.DURACION_CLASE,
           h.CUPO_HORARIO
    FROM clase c
    JOIN horario h 
        ON c.ID_CLASE = h.ID_CLASE
    WHERE CAST(c.DURACION_CLASE AS UNSIGNED) > :duracion
        AND h.CUPO_HORARIO < :cupo
    """, nativeQuery = true)
    List<Object[]> obtenerClasesPorTiempoYCupo(@Param("duracion") Integer duracion, @Param("cupo") Integer cupo);
}
