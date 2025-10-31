package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.SuscripcionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class SuscripcionService implements InterfaceService<SuscripcionDTO> {

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
    public void eliminar(SuscripcionDTO suscripcionDTO) {

    }
}
