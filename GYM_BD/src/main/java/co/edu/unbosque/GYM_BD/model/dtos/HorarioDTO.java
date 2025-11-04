package co.edu.unbosque.GYM_BD.model.dtos;

import java.time.LocalTime;

public class HorarioDTO {

    private Integer idHorario;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer cupo;
    private ClaseDTO clase;

    public HorarioDTO() {}

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public ClaseDTO getClase() {
        return clase;
    }

    public void setClase(ClaseDTO clase) {
        this.clase = clase;
    }
}
