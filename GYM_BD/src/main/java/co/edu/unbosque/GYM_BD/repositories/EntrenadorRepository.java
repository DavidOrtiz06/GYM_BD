package co.edu.unbosque.GYM_BD.repositories;

import co.edu.unbosque.GYM_BD.model.entities.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, String> {

    @Query(value = """
    SELECT NOMBRE_ENTRENADOR
    FROM entrenador
    WHERE TURNO_ENTRENADOR = :turno
    """, nativeQuery = true)
    List<Object[]> obtenerEntrenadoresPorTurno(@Param("turno") String turno);
}
