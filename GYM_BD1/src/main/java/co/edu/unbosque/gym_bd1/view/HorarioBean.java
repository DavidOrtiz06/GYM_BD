package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ClaseDTO;
import co.edu.unbosque.gym_bd1.model.HorarioDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceHorario;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("horarioBean")
@ViewScoped
public class HorarioBean implements Serializable {

    private HorarioDTO horarioDto;
    private ClaseDTO claseDto;
    private List<Object[]> horariosClase;
    private String nombreClase;

    @Inject
    private InterfaceHorario horarioService;

    @PostConstruct
    public void init() {
        horarioDto = new HorarioDTO();
        claseDto = new ClaseDTO();
    }

    public List<HorarioDTO> listarHorarios() throws JsonProcessingException {
        return horarioService.listar();
    }

    public void actualizarHorario(HorarioDTO horario) throws JsonProcessingException {
        horarioDto = horario;
        horarioDto.setCupo(horario.getCupo() - 1);
        horarioService.actualizar(horarioDto, horarioDto.getIdHorario());
    }

    public void obtenerHorariosPorClase(String clase) throws JsonProcessingException {
        horariosClase = horarioService.listarHorariosPorClase(clase);
    }

    public HorarioDTO getHorarioDto() {
        return horarioDto;
    }

    public void setHorarioDto(HorarioDTO horarioDto) {
        this.horarioDto = horarioDto;
    }

    public ClaseDTO getClaseDto() {
        return claseDto;
    }

    public void setClaseDto(ClaseDTO claseDto) {
        this.claseDto = claseDto;
    }

    public List<Object[]> getHorariosClase() {
        return horariosClase;
    }

    public void setHorariosClase(List<Object[]> horariosClase) {
        this.horariosClase = horariosClase;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
}
