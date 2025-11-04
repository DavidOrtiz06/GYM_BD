package co.edu.unbosque.gym_bd1.services.interfaces;

import co.edu.unbosque.gym_bd1.model.SuscripcionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceSuscripcion extends InterfaceService<SuscripcionDTO> {

    List<Object[]> listarSuscripcionesVigentes() throws JsonProcessingException;
    List<Object[]> listarClientesSinSuscripcionActiva() throws JsonProcessingException;
}
