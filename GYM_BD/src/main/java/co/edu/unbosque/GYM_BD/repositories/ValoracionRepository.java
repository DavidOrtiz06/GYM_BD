package co.edu.unbosque.GYM_BD.repositories;

import co.edu.unbosque.GYM_BD.model.entities.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Integer> {

    @Query(value = """
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
    WHERE v.ESTADO_VALORACION = :estado
    """, nativeQuery = true)
    List<Object[]> obtenerValoracionesPorEstado(@Param("estado") String estado);

    @Query(value = """
    SELECT v.FECHA_VALORACION, 
           v.HORA_VALORACION,
           v.ESTADO_VALORACION,
           f.NOMBRE_FISIOTERAPEUTA
    FROM valoracion v
    JOIN fisioterapeuta f 
        ON v.NUM_DOC_FISIOTERAPEUTA = f.NUM_DOC_FISIOTERAPEUTA
    WHERE v.FECHA_VALORACION = :fecha
    """, nativeQuery = true)
    List<Object[]> obtenerValoracionesPorFecha(@Param("fecha") LocalDate fecha);
}
