package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.ActualizarValoracionDTO;
import co.edu.unbosque.gym_bd1.model.ValoracionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Stateless
public class ValoracionService implements InterfaceService<ValoracionDTO, Integer> {

    private ApiService apiService;

    public ValoracionService() {
        apiService = new ApiService();
    }

    @Override
    public ValoracionDTO registrar(ValoracionDTO valoracion) throws JsonProcessingException {
        return apiService.registrar("valoraciones", valoracion, ValoracionDTO.class);
    }

    @Override
    public List<ValoracionDTO> listar() throws JsonProcessingException {
        return apiService.listar("valoraciones", ValoracionDTO.class);
    }

    @Override
    public ValoracionDTO actualizar(ValoracionDTO valoracion, Integer idValoracion) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8081/gimnasio/api/valoraciones/" + idValoracion + "/estado");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ActualizarValoracionDTO actualizarValoracion = new ActualizarValoracionDTO();
        actualizarValoracion.setEstado(valoracion.getEstado());
        actualizarValoracion.setRestricciones(valoracion.getRestricciones());
        Response response = target.request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(objectMapper.writeValueAsString(actualizarValoracion), MediaType.APPLICATION_JSON));
        if (response.getStatus() == 201) {
            return objectMapper.readValue(response.readEntity(String.class), ValoracionDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(ValoracionDTO valoracionDTO) {

    }
}
