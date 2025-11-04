package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ClaseDTO;
import co.edu.unbosque.gym_bd1.model.ClienteDTO;
import co.edu.unbosque.gym_bd1.model.HorarioDTO;
import co.edu.unbosque.gym_bd1.model.IngresoDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceService;
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

@Named("ingresoBean")
@ViewScoped
public class IngresoBean implements Serializable {

    private IngresoDTO ingresoDto;
    private ClienteDTO clienteDto;
    private ClaseDTO claseDto;
    private HorarioDTO horarioDto;
    private List<IngresoDTO> ingresosPorHorario;

    @Inject
    private InterfaceService<IngresoDTO> ingresoService;
    @Inject
    private HorarioBean horarioBean;

    @PostConstruct
    public void init() {
        ingresoDto = new IngresoDTO();
        clienteDto = new ClienteDTO();
        claseDto = new ClaseDTO();
        horarioDto = new HorarioDTO();
    }

    public void registrarIngreso() throws JsonProcessingException {
        claseDto.setIdClase(horarioDto.getClase().getIdClase());
        ingresoDto.setCliente(clienteDto);
        ingresoDto.setClase(claseDto);
        ingresoService.registrar(ingresoDto);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingreso del cliente a la clase cargado.", null));
        horarioBean.actualizarHorario(horarioDto);
        ingresoDto = new IngresoDTO();
    }

    public List<IngresoDTO> listarIngresos() throws JsonProcessingException {
        return ingresoService.listar();
    }

    public void cargarIngresosPorHorario() throws JsonProcessingException {
        List<IngresoDTO> ingresos = listarIngresos();
        ingresosPorHorario = new ArrayList<>();
        for (IngresoDTO ingreso : ingresos) {
            if(ingreso.getClase().getIdClase() == horarioDto.getClase().getIdClase()) {
                ingresosPorHorario.add(ingreso);
            }
        }
    }

    public void crearIngreso() {
        System.out.println("Creando Ingreso");
    }

    public IngresoDTO getIngresoDto() {
        return ingresoDto;
    }

    public void setIngresoDto(IngresoDTO ingresoDto) {
        this.ingresoDto = ingresoDto;
    }

    public ClienteDTO getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDTO clienteDto) {
        this.clienteDto = clienteDto;
    }

    public ClaseDTO getClaseDto() {
        return claseDto;
    }

    public void setClaseDto(ClaseDTO claseDto) {
        this.claseDto = claseDto;
    }

    public HorarioDTO getHorarioDto() {
        return horarioDto;
    }

    public void setHorarioDto(HorarioDTO horarioDto) throws JsonProcessingException {
        this.horarioDto = horarioDto;
        cargarIngresosPorHorario();
    }

    public List<IngresoDTO> getIngresosPorHorario() {
        return ingresosPorHorario;
    }

    public void setIngresosPorHorario(List<IngresoDTO> ingresosPorHorario) {
        this.ingresosPorHorario = ingresosPorHorario;
    }
}
