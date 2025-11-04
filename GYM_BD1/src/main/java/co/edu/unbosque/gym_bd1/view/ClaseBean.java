package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ClaseDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceClase;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("claseBean")
@ViewScoped
public class ClaseBean implements Serializable {

    private ClaseDTO claseDto;
    private List<Object[]> clasesFiltradas;
    private Integer cupoBusqueda;
    private Integer duracionBusqueda;

    @Inject
    private InterfaceClase claseService;

    @PostConstruct
    public void init() {
        claseDto = new ClaseDTO();
    }

    public void registrarClase() throws JsonProcessingException {
        claseService.registrar(claseDto);
        claseDto = new ClaseDTO();
    }

    public List<ClaseDTO> listarClases() throws JsonProcessingException {
        return claseService.listar();
    }

    public void obtenerClasesConCupoMayorA(Integer cupo) throws JsonProcessingException {
        clasesFiltradas = claseService.listarClasesConCupoMayorA(cupo);
    }

    public void obtenerClasesPorTiempoYCupo(Integer tiempo, Integer cupo) throws JsonProcessingException {
        clasesFiltradas = claseService.listarClasesPorTiempoYCupo(tiempo, cupo);
    }

    public void limpiarLista() {
        clasesFiltradas = new ArrayList<>();
    }

    public ClaseDTO getClaseDto() {
        return claseDto;
    }

    public void setClaseDto(ClaseDTO claseDto) {
        this.claseDto = claseDto;
    }

    public List<Object[]> getClasesFiltradas() {
        return clasesFiltradas;
    }

    public void setClasesFiltradas(List<Object[]> clasesFiltradas) {
        this.clasesFiltradas = clasesFiltradas;
    }

    public Integer getCupoBusqueda() {
        return cupoBusqueda;
    }

    public void setCupoBusqueda(Integer cupoBusqueda) {
        this.cupoBusqueda = cupoBusqueda;
    }

    public Integer getDuracionBusqueda() {
        return duracionBusqueda;
    }

    public void setDuracionBusqueda(Integer duracionBusqueda) {
        this.duracionBusqueda = duracionBusqueda;
    }
}
