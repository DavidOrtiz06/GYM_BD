package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.EntrenadorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class EntrenadorService implements InterfaceService<EntrenadorDTO, String> {

    private ApiService apiService;

    public EntrenadorService() {
        apiService = new ApiService();
    }

    @Override
    public EntrenadorDTO registrar(EntrenadorDTO entrenador) throws JsonProcessingException {
        return apiService.registrar("entrenadores", entrenador, EntrenadorDTO.class);
    }

    @Override
    public List<EntrenadorDTO> listar() throws JsonProcessingException {
        return apiService.listar("entrenadores", EntrenadorDTO.class);
    }

    @Override
    public EntrenadorDTO actualizar(EntrenadorDTO entrenador, String id) throws JsonProcessingException {
        return null;
    }

    @Override
    public void eliminar(EntrenadorDTO entrenadorDTO) {

    }
}
