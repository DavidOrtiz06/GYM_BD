package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.ActualizarHorarioDTO;
import co.edu.unbosque.gym_bd1.model.HorarioDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceHorario;
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
public class HorarioService implements InterfaceHorario {

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
    public HorarioDTO actualizar(HorarioDTO horario, Integer idHorario) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8081/gimnasio/api/horarios/" + idHorario + "/cupo");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ActualizarHorarioDTO actualizarHorario = new ActualizarHorarioDTO();
        actualizarHorario.setCupo(horario.getCupo());
        Response response = target.request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(objectMapper.writeValueAsString(actualizarHorario), MediaType.APPLICATION_JSON));
        if (response.getStatus() == 201) {
            return objectMapper.readValue(response.readEntity(String.class), HorarioDTO.class);
        } else {
            return null;
        }
    }

    public List<Object[]> listarHorariosPorClase(String clase) throws JsonProcessingException {
        return apiService.listar("horarios/" + clase, Object[].class);
    }
}
