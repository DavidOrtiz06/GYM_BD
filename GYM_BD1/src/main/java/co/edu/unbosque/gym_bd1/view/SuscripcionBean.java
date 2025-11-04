package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.SuscripcionDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceSuscripcion;
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
    private List<Object[]> suscripcionesVigentes;
    private List<Object[]> suscripcionesInactivas;

    @Inject
    private InterfaceSuscripcion suscripcionService;

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

    public void obtenerSuscripcionesVigentes() throws JsonProcessingException {
        suscripcionesVigentes = suscripcionService.listarSuscripcionesVigentes();
    }

    public void listarClientesSinSuscripcionActiva() throws JsonProcessingException {
        suscripcionesInactivas = suscripcionService.listarClientesSinSuscripcionActiva();
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

    public List<Object[]> getSuscripcionesVigentes() {
        return suscripcionesVigentes;
    }

    public void setSuscripcionesVigentes(List<Object[]> suscripcionesVigentes) {
        this.suscripcionesVigentes = suscripcionesVigentes;
    }

    public List<Object[]> getSuscripcionesInactivas() {
        return suscripcionesInactivas;
    }

    public void setSuscripcionesInactivas(List<Object[]> suscripcionesInactivas) {
        this.suscripcionesInactivas = suscripcionesInactivas;
    }
}
