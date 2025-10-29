package co.edu.unbosque.GYM_BD.model.dtos;

public class HorarioDTO {

    private int idHorario;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private ClaseDTO idClase;

    public HorarioDTO() {}

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
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
