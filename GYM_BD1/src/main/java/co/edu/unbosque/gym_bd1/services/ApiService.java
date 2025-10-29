package co.edu.unbosque.gym_bd1.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class ApiService {

    private static final String BASE_URL = "http://localhost:8081/gimnasio/api/";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T registrar(String endpoint, T dto, Class<T> responseType) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL + endpoint);
        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(objectMapper.writeValueAsString(dto), MediaType.APPLICATION_JSON));
        if (response.getStatus() == 201) {
            return objectMapper.readValue(response.readEntity(String.class), responseType);
        } else {
            System.err.println("Error al registrar en " + endpoint + ": " + response.getStatus());
            return null;
        }
    }

    public <T> List<T> listar(String endpoint, Class<T> responseType) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL + endpoint);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
            return response.readEntity(new GenericType<List<T>>() {
            });
        } else {
            System.err.println("Error al listar en " + endpoint + ": " + response.getStatus());
            return new ArrayList<>();
        }
    }
}
