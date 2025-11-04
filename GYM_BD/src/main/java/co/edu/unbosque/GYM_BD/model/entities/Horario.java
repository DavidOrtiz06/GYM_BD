package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "horario")
public class Horario implements Serializable {

    @Id
    @Column(name = "ID_HORARIO")
    private Integer idHorario;

    @Column(name = "DIA")
    private String dia;

    @Column(name = "HORA_INICIO")
    private LocalTime horaInicio;

    @Column(name = "HORA_FIN")
    private LocalTime horaFin;

    @Column(name = "CUPO_HORARIO")
    private Integer cupo;

    @ManyToOne
    @JoinColumn(name = "ID_CLASE")
    private Clase clase;

    public Horario() {}

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

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
