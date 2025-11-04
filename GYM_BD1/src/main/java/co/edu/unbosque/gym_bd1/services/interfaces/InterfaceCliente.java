package co.edu.unbosque.gym_bd1.services.interfaces;

import co.edu.unbosque.gym_bd1.model.ClienteDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceCliente extends InterfaceService<ClienteDTO> {

    List<Object[]> listarCLientesConMultiplesHorarios(Integer totalClases) throws JsonProcessingException;
}
