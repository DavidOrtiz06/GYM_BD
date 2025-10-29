package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.ClienteDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ClienteService implements InterfaceService<ClienteDTO>{

    private final ApiService apiService;

    public ClienteService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public ClienteDTO registrar(ClienteDTO cliente) throws JsonProcessingException {
        return apiService.registrar("clientes", cliente, ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> listar() {
        return apiService.listar("clientes", ClienteDTO.class);
    }
}
