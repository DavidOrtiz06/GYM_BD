package co.edu.unbosque.gym_bd1.services;

import co.edu.unbosque.gym_bd1.model.IngresoDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class IngresoService implements InterfaceService<IngresoDTO> {

    private ApiService apiService;

    public IngresoService() {
        apiService = new ApiService();
    }

    @Override
    public IngresoDTO registrar(IngresoDTO ingreso) throws JsonProcessingException {
        return apiService.registrar("ingresos", ingreso, IngresoDTO.class);
    }

    @Override
    public List<IngresoDTO> listar() throws JsonProcessingException {
        return apiService.listar("ingresos", IngresoDTO.class);
    }
}
