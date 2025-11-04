package co.edu.unbosque.gym_bd1.services.interfaces;

import co.edu.unbosque.gym_bd1.model.EntrenadorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceEntrenador extends InterfaceService<EntrenadorDTO> {

    List<Object[]> listarEntrenadorPorTurno(String turno) throws JsonProcessingException;
}
