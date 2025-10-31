package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.HorarioDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class HorarioService implements InterfaceService<HorarioDTO> {

    private ApiService apiService;

    public HorarioService() {
        apiService = new ApiService();
    }

    @Override
    public HorarioDTO registrar(HorarioDTO horario) throws JsonProcessingException {
        return apiService.registrar("horarios", horario, HorarioDTO.class);
    }

    @Override
    public List<HorarioDTO> listar() throws JsonProcessingException {
        return apiService.listar("horarios", HorarioDTO.class);
    }

    @Override
    public void eliminar(HorarioDTO horarioDTO) {

    }
}
