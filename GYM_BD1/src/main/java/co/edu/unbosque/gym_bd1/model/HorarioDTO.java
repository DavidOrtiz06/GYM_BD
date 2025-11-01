package co.edu.unbosque.gym_bd1.model;

public class HorarioDTO {

    private Integer idHorario;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private ClaseDTO idClase;

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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public ClaseDTO getIdClase() {
        return idClase;
    }

    public void setIdClase(ClaseDTO idClase) {
        this.idClase = idClase;
    }
}
