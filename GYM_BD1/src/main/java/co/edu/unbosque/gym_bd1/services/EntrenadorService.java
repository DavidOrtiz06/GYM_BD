package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.EntrenadorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class EntrenadorService implements InterfaceService<EntrenadorDTO> {

    private final ApiService apiService;

    public EntrenadorService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public EntrenadorDTO registrar(EntrenadorDTO entrenador) throws JsonProcessingException {
        return apiService.registrar("entrenadores", entrenador, EntrenadorDTO.class);
    }

    @Override
    public List<EntrenadorDTO> listar() {
        return apiService.listar("entrenadores", EntrenadorDTO.class);
    }
}
