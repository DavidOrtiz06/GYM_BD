package co.edu.unbosque.gym_bd1.services.interfaces;

import co.edu.unbosque.gym_bd1.model.HorarioDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceHorario extends InterfaceService<HorarioDTO> {

    HorarioDTO actualizar(HorarioDTO horario, Integer idHorario) throws JsonProcessingException;
    List<Object[]> listarHorariosPorClase(String clase) throws JsonProcessingException;
}
