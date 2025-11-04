package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "suscripcion")
public class Suscripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUSCRIPCION")
    private Integer idSuscripcion;

    @Column(name = "FECHA_INICIO_SUSCRIPCION")
    private LocalDateTime fechaInicio;

    @Column(name = "FECHA_FIN_SUSCRIPCION")
    private LocalDateTime fechaFin;

    @Column(name = "ESTADO_SUSCRIPCION")
    private String estado;

    @Column(name = "MESES_SUSCRIPCION")
    private Integer meses;

    public Suscripcion() {}

    public Integer getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(Integer idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }
}
