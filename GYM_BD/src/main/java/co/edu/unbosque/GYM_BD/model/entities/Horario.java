package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "horario")
public class Horario implements Serializable {

    @Id
    @Column(name = "ID_HORARIO")
    private int idHorario;

    @Column(name = "DIA")
    private String dia;

    @Column(name = "HORA_INICIO")
    private String horaInicio;

    @Column(name = "HORA_FIN")
    private String horaFin;

    @ManyToOne
    @JoinColumn(name = "ID_CLASE")
    private Clase clase;

    public Horario() {}

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

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
