package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.EntrenadorDTO;
import co.edu.unbosque.gym_bd1.services.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("entrenadorBean")
@ViewScoped
public class EntrenadorBean implements Serializable {

    private EntrenadorDTO entrenadorDto;
    private List<EntrenadorDTO> entrenadoresFiltrados;

    @Inject
    private InterfaceService<EntrenadorDTO, String> entrenadorService;
    @Inject
    private TablaBean tablaBean;

    @PostConstruct
    public void init() {
        entrenadorDto = new EntrenadorDTO();
    }

    public void registrarEntrenador() throws JsonProcessingException {
        entrenadorService.registrar(entrenadorDto);
        entrenadorDto = new EntrenadorDTO();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Entrenador registrado correctamente.", null));
        if("entrenador".equals(tablaBean.getTipoActual())){
            tablaBean.listarEntidad("entrenador");
        }
        entrenadoresFiltrados = listarEntrenadores();
    }

    public List<EntrenadorDTO> listarEntrenadores() throws JsonProcessingException {
        return entrenadorService.listar();
    }

    public void crearEntrenador() {
        System.out.println("Creando entrenador");
    }

    public EntrenadorDTO getEntrenadorDto() {
        return entrenadorDto;
    }

    public void setEntrenadorDto(EntrenadorDTO entrenadorDto) {
        this.entrenadorDto = entrenadorDto;
    }

    public List<EntrenadorDTO> getEntrenadoresFiltrados() throws JsonProcessingException {
        if(entrenadoresFiltrados == null){
            entrenadoresFiltrados = listarEntrenadores();
        }
        return entrenadoresFiltrados;
    }

    public void setEntrenadoresFiltrados(List<EntrenadorDTO> entrenadoresFiltrados) {
        this.entrenadoresFiltrados = entrenadoresFiltrados;
    }
}
