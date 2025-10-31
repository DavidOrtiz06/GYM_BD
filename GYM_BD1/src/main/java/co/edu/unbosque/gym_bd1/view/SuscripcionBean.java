package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.SuscripcionDTO;
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

@Named("suscripcionBean")
@ViewScoped
public class SuscripcionBean implements Serializable {

    private SuscripcionDTO suscripcionDto;

    @Inject
    private InterfaceService<SuscripcionDTO> suscripcionService;

    @PostConstruct
    public void init() {
        suscripcionDto = new SuscripcionDTO();
    }

    public void registrarSuscripcion() throws JsonProcessingException {
        suscripcionService.registrar(suscripcionDto);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Suscripción registrada.", null));
    }

    public List<SuscripcionDTO> listarSuscripciones() throws JsonProcessingException {
        return suscripcionService.listar();
    }

    public SuscripcionDTO obtenerUltimaSuscripcion() throws JsonProcessingException {
        List<SuscripcionDTO> suscripciones = listarSuscripciones();
        if(!suscripciones.isEmpty()){
            return suscripciones.get(suscripciones.size()-1);
        } else {
            System.out.println("No se puede obtener una ultima suscripcion.");
            return null;
        }
    }

    public void seleccionarMeses(int meses) {
        suscripcionDto.setMeses(meses);
    }

    public SuscripcionDTO getSuscripcionDto() {
        return suscripcionDto;
    }

    public void setSuscripcionDto(SuscripcionDTO suscripcionDto) {
        this.suscripcionDto = suscripcionDto;
    }
}
