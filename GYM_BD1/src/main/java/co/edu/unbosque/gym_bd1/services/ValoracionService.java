package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.ValoracionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ValoracionService implements InterfaceService<ValoracionDTO> {

    private final ApiService apiService;

    public ValoracionService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public ValoracionDTO registrar(ValoracionDTO valoracion) throws JsonProcessingException {
        return apiService.registrar("valoraciones", valoracion, ValoracionDTO.class);
    }

    @Override
    public List<ValoracionDTO> listar() {
        return apiService.listar("valoraciones", ValoracionDTO.class);
    }
}
