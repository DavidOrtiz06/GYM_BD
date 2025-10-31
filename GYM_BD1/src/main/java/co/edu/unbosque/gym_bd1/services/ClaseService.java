package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.ClaseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ClaseService implements InterfaceService<ClaseDTO> {

    private ApiService apiService;

    public ClaseService() {
        apiService = new ApiService();
    }

    @Override
    public ClaseDTO registrar(ClaseDTO clase) throws JsonProcessingException {
        return apiService.registrar("clases", clase, ClaseDTO.class);
    }

    @Override
    public List<ClaseDTO> listar() throws JsonProcessingException {
        return apiService.listar("clases", ClaseDTO.class);
    }

    @Override
    public void eliminar(ClaseDTO claseDTO) {

    }
}
