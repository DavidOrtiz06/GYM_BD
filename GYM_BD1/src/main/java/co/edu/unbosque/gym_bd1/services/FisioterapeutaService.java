package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.FisioterapeutaDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceFisioterapeuta;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class FisioterapeutaService implements InterfaceFisioterapeuta {

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
    public List<Object[]> listarClientesPorFisioterapeuta(String numDocumentoFisioterapeuta) throws JsonProcessingException {
        return apiService.listar("fisioterapeutas/" + numDocumentoFisioterapeuta, Object[].class);
    }
}
