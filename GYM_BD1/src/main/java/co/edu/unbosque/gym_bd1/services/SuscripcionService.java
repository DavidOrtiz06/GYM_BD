package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.SuscripcionDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceSuscripcion;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class SuscripcionService implements InterfaceSuscripcion {

    private final ApiService apiService = new ApiService();

    @Override
    public SuscripcionDTO registrar(SuscripcionDTO suscripcion) throws JsonProcessingException {
        return apiService.registrar("suscripciones", suscripcion, SuscripcionDTO.class);
    }

    @Override
    public List<SuscripcionDTO> listar() throws JsonProcessingException {
        return apiService.listar("suscripciones", SuscripcionDTO.class);
    }

    @Override
    public List<Object[]> listarSuscripcionesVigentes() throws JsonProcessingException {
        return apiService.listar("suscripciones/vigentes", Object[].class);
    }

    @Override
    public List<Object[]> listarClientesSinSuscripcionActiva() throws JsonProcessingException {
        return apiService.listar("suscripciones/clientes/inactiva", Object[].class);
    }
}
