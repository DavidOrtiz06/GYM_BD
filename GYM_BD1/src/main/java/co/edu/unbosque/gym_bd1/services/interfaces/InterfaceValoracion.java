package co.edu.unbosque.gym_bd1.services.interfaces;

import co.edu.unbosque.gym_bd1.model.ValoracionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.util.List;

public interface InterfaceValoracion extends InterfaceService<ValoracionDTO> {

    ValoracionDTO actualizar(ValoracionDTO valoracion, Integer idValoracion) throws JsonProcessingException;
    List<Object[]> listarValoracionesPorEstado(String estado) throws JsonProcessingException;
    List<Object[]> listarValoracionesPorFecha(LocalDate fecha) throws JsonProcessingException;
}
