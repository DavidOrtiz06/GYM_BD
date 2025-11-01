package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ClaseDTO;
import co.edu.unbosque.gym_bd1.services.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("claseBean")
@ViewScoped
public class ClaseBean implements Serializable {

    @Inject
    private InterfaceService<ClaseDTO, Integer> claseService;

    private List<ClaseDTO> clases;
    private ClaseDTO nuevaClase;

    @PostConstruct
    public void init() {
        nuevaClase = new ClaseDTO();
    }

    public void abrirNueva() { nuevaClase = new ClaseDTO(); }

    public void registrar() {
        try {
            claseService.registrar(nuevaClase);
            clases = claseService.listar();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public List<ClaseDTO> getClases() { return clases; }
    public ClaseDTO getNuevaClase() { return nuevaClase; }
}
