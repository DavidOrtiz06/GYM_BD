package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.FisioterapeutaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class FisioterapeutaService implements InterfaceService<FisioterapeutaDTO, String> {

    private ApiService apiService;

    public FisioterapeutaService() {
        apiService = new ApiService();
    }

    @Override
    public FisioterapeutaDTO registrar(FisioterapeutaDTO fisioterapeuta) throws JsonProcessingException {
        return apiService.registrar("fisioterapeutas", fisioterapeuta, FisioterapeutaDTO.class);
    }

    @Override
    public List<FisioterapeutaDTO> listar() throws JsonProcessingException {
        return apiService.listar("fisioterapeutas", FisioterapeutaDTO.class);
    }

    @Override
    public FisioterapeutaDTO actualizar(FisioterapeutaDTO fisioterapeuta, String id) throws JsonProcessingException {
        return null;
    }

    @Override
    public void eliminar(FisioterapeutaDTO fisioterapeutaDTO) {

    }
}
