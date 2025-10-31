package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.EntrenadorDTO;
import co.edu.unbosque.gym_bd1.services.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("entrenadorBean")
@ViewScoped
public class EntrenadorBean implements Serializable {

    @Inject
    private InterfaceService<EntrenadorDTO> entrenadorService;

    private List<EntrenadorDTO> entrenadores;
    private EntrenadorDTO nuevoEntrenador;

    @PostConstruct
    public void init() {
        nuevoEntrenador = new EntrenadorDTO();
    }

    public void abrirNuevo() { nuevoEntrenador = new EntrenadorDTO(); }

    public void registrar() {
        try {
            entrenadorService.registrar(nuevoEntrenador);
            entrenadores = entrenadorService.listar();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public List<EntrenadorDTO> getEntrenadores() { return entrenadores; }
    public EntrenadorDTO getNuevoEntrenador() { return nuevoEntrenador; }
}
