package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ValoracionDTO;
import co.edu.unbosque.gym_bd1.services.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("valoracionBean")
@ViewScoped
public class ValoracionBean implements Serializable {

    @Inject
    private InterfaceService<ValoracionDTO> valoracionService;

    private List<ValoracionDTO> valoraciones;
    private ValoracionDTO nuevaValoracion;

    @PostConstruct
    public void init() {
        nuevaValoracion = new ValoracionDTO();
    }

    public void abrirNueva() { nuevaValoracion = new ValoracionDTO(); }

    public void registrar() {
        try {
            valoracionService.registrar(nuevaValoracion);
            valoraciones = valoracionService.listar();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public List<ValoracionDTO> getValoraciones() { return valoraciones; }
    public ValoracionDTO getNuevaValoracion() { return nuevaValoracion; }
}
