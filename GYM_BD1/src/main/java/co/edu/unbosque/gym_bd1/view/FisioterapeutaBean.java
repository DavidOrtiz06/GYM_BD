package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.FisioterapeutaDTO;
import co.edu.unbosque.gym_bd1.services.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("fisioterapeutaBean")
@ViewScoped
public class FisioterapeutaBean implements Serializable {

    @Inject
    private InterfaceService<FisioterapeutaDTO> fisioterapeutaService;

    private List<FisioterapeutaDTO> fisioterapeutas;
    private FisioterapeutaDTO nuevoFisio;

    @PostConstruct
    public void init() {
        nuevoFisio = new FisioterapeutaDTO();
    }

    public void abrirNuevo() { nuevoFisio = new FisioterapeutaDTO(); }

    public void registrar() {
        try {
            fisioterapeutaService.registrar(nuevoFisio);
            fisioterapeutas = fisioterapeutaService.listar();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public List<FisioterapeutaDTO> getFisioterapeutas() { return fisioterapeutas; }
    public FisioterapeutaDTO getNuevoFisio() { return nuevoFisio; }
}
