package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.EntrenadorDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceEntrenador;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class EntrenadorService implements InterfaceEntrenador {

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
    public List<Object[]> listarEntrenadorPorTurno(String turno) throws JsonProcessingException {
        return apiService.listar("entrenadores/" + turno, Object[].class);
    }
}
