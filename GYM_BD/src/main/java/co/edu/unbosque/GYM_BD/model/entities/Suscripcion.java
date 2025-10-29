package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "suscripcion")
public class Suscripcion implements Serializable {

    @Id
    @Column(name = "ID_SUSCRIPCION")
    private int idSuscripcion;

    @Column(name = "FECHA_INICIO_SUSCRIPCION")
    private Date fechaInicio;

    @Column(name = "FECHA_FIN_SUSCRIPCION")
    private Date fechaFin;

    @Column(name = "ESTADO_SUSCRIPCION")
    private String estado;

    public Suscripcion() {}

    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
