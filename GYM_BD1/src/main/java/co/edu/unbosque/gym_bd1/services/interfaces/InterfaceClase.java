package co.edu.unbosque.gym_bd1.services.interfaces;

import co.edu.unbosque.gym_bd1.model.ClaseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceClase extends InterfaceService<ClaseDTO> {

    List<Object[]> listarClasesConCupoMayorA(Integer cupo) throws JsonProcessingException;
    List<Object[]> listarClasesPorTiempoYCupo(Integer duracion, Integer cupo) throws JsonProcessingException;
}
