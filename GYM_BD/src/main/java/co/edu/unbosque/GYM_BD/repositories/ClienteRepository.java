package co.edu.unbosque.GYM_BD.repositories;

import co.edu.unbosque.GYM_BD.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(value = """
    SELECT c.NUM_DOC_CLIENTE, 
           c.NOMBRE_CLIENTE, 
           COUNT(i.ID_CLASE) AS TOTAL_CLASES
    FROM cliente c
    JOIN ingreso i 
        ON c.NUM_DOC_CLIENTE = i.NUM_DOC_CLIENTE
    GROUP BY c.NUM_DOC_CLIENTE, 
             c.NOMBRE_CLIENTE
    HAVING COUNT(i.ID_CLASE) > :totalClases
    """, nativeQuery = true)
    List<Object[]> obtenerClientesConMultiplesClases(@Param("totalClases") Integer totalClases);
}
