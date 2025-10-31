package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.HorarioDTO;
import co.edu.unbosque.gym_bd1.services.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("horarioBean")
@ViewScoped
public class HorarioBean implements Serializable {

    @Inject
    private InterfaceService<HorarioDTO> horarioService;

    private List<HorarioDTO> horarios;
    private HorarioDTO nuevoHorario;

    @PostConstruct
    public void init() {
        nuevoHorario = new HorarioDTO();
    }

    public void abrirNuevo() { nuevoHorario = new HorarioDTO(); }

    public void registrar() {
        try {
            horarioService.registrar(nuevoHorario);
            horarios = horarioService.listar();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public List<HorarioDTO> getHorarios() { return horarios; }
    public HorarioDTO getNuevoHorario() { return nuevoHorario; }
}
