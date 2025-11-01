package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.ClienteDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ClienteService implements InterfaceService<ClienteDTO, String>{

    private ApiService apiService;

    public ClienteService() {
        apiService = new ApiService();
    }

    @Override
    public ClienteDTO registrar(ClienteDTO cliente) throws JsonProcessingException {
        return apiService.registrar("clientes", cliente, ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> listar() throws JsonProcessingException {
        return apiService.listar("clientes", ClienteDTO.class);
    }

    @Override
    public ClienteDTO actualizar(ClienteDTO cliente, String id) throws JsonProcessingException {
        return null;
    }

    @Override
    public void eliminar(ClienteDTO clienteDTO) {

    }
}
