package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.FisioterapeutaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class FisioterapeutaService implements InterfaceService<FisioterapeutaDTO> {

    private final ApiService apiService;

    public FisioterapeutaService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public FisioterapeutaDTO registrar(FisioterapeutaDTO fisioterapeuta) throws JsonProcessingException {
        return apiService.registrar("fisioterapeutas", fisioterapeuta, FisioterapeutaDTO.class);
    }

    @Override
    public List<FisioterapeutaDTO> listar() {
        return apiService.listar("fisioterapeutas", FisioterapeutaDTO.class);
    }
}
