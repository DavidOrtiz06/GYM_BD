package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.HorarioDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class HorarioService implements InterfaceService<HorarioDTO> {

    private final ApiService apiService;

    public HorarioService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public HorarioDTO registrar(HorarioDTO horario) throws JsonProcessingException {
        return apiService.registrar("horarios", horario, HorarioDTO.class);
    }

    @Override
    public List<HorarioDTO> listar() {
        return apiService.listar("horarios", HorarioDTO.class);
    }
}
