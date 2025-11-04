package co.edu.unbosque.GYM_BD.repositories;

import co.edu.unbosque.GYM_BD.model.entities.Ingreso;
import co.edu.unbosque.GYM_BD.model.entities.IngresoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, IngresoId> {
}
