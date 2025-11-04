package co.edu.unbosque.GYM_BD.repositories;

import co.edu.unbosque.GYM_BD.model.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @Query(value = """
    SELECT h.DIA, 
           h.HORA_INICIO, 
           h.HORA_FIN,
           h.CUPO_HORARIO
    FROM clase c
    JOIN horario h 
        ON c.ID_CLASE = h.ID_CLASE
    WHERE c.NOMBRE_CLASE = :clase
    """, nativeQuery = true)
    List<Object[]> obtenerHorariosPorClase(@Param("clase") String clase);
}
