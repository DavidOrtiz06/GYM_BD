package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.ClienteDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceCliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ClienteService implements InterfaceCliente {

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
    public List<Object[]> listarCLientesConMultiplesHorarios(Integer totalClases) throws JsonProcessingException {
        return apiService.listar("clientes/clases/" + totalClases, Object[].class);
    }
}
