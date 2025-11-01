package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.FisioterapeutaDTO;
import co.edu.unbosque.gym_bd1.services.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("fisioterapeutaBean")
@ViewScoped
public class FisioterapeutaBean implements Serializable {

    private FisioterapeutaDTO fisioterapeutaDto;
    private List<FisioterapeutaDTO> fisioterapeutasFiltrados;

    @Inject
    private InterfaceService<FisioterapeutaDTO, String> fisioterapeutaService;
    @Inject
    private TablaBean tablaBean;

    @PostConstruct
    public void init() {
        fisioterapeutaDto = new FisioterapeutaDTO();
    }

    public void registrarFisioterapeuta() throws JsonProcessingException {
        fisioterapeutaService.registrar(fisioterapeutaDto);
        fisioterapeutaDto = new FisioterapeutaDTO();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Fisioterapeuta registrado correctamente.", null));
        if("fisioterapeuta".equals(tablaBean.getTipoActual())){
            tablaBean.listarEntidad("fisioterapeuta");
        }
        fisioterapeutasFiltrados = listarFisioterapeutas();
    }

    public List<FisioterapeutaDTO> listarFisioterapeutas() throws JsonProcessingException {
        return fisioterapeutaService.listar();
    }

    public void crearFisioterapeuta() {
        System.out.println("Creando Fisioterapeuta");
    }

    public FisioterapeutaDTO getFisioterapeutaDto() {
        return fisioterapeutaDto;
    }

    public void setFisioterapeutaDto(FisioterapeutaDTO fisioterapeutaDto) {
        this.fisioterapeutaDto = fisioterapeutaDto;
    }

    public List<FisioterapeutaDTO> getFisioterapeutasFiltrados() throws JsonProcessingException {
        if(fisioterapeutasFiltrados == null) {
            fisioterapeutasFiltrados = listarFisioterapeutas();
        }
        return fisioterapeutasFiltrados;
    }

    public void setFisioterapeutasFiltrados(List<FisioterapeutaDTO> fisioterapeutasFiltrados) {
        this.fisioterapeutasFiltrados = fisioterapeutasFiltrados;
    }
}
