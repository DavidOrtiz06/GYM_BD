package co.edu.unbosque.GYM_BD.repositories;

import co.edu.unbosque.GYM_BD.model.entities.Fisioterapeuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FisioterapeutaRepository extends JpaRepository<Fisioterapeuta, String> {

    @Query(value = """
    SELECT DISTINCT c.NUM_DOC_CLIENTE, 
                    c.NOMBRE_CLIENTE
    FROM cliente c
    JOIN valoracion v 
        ON c.NUM_DOC_CLIENTE = v.NUM_DOC_CLIENTE
    WHERE v.NUM_DOC_FISIOTERAPEUTA = :numDocumentoFisioterapeuta
    """, nativeQuery = true)
    List<Object[]> obtenerClientesPorFisioterapeuta(@Param("numDocumentoFisioterapeuta") String numDocumentoFisioterapeuta);
}
