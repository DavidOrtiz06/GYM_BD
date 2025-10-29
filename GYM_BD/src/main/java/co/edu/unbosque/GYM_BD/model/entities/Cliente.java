package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @Column(name = "NUM_DOC_CLIENTE")
    private String numDocumentoCliente;

    @Column(name = "NOMBRE_CLIENTE")
    private String nombre;

    @Column(name = "CORREO_CLIENTE")
    private String correo;

    @Column(name = "ESTADO_CLIENTE")
    private String estado;

    @Column(name = "NUM_TELEFONO_CLIENTE")
    private String numTelefono;

    @ManyToOne
    @JoinColumn(name = "ID_SUSCRIPCION")
    private Suscripcion suscripcion;

    public Cliente(){}

    public String getNumDocumentoCliente() {
        return numDocumentoCliente;
    }

    public void setNumDocumentoCliente(String numDocumentoCliente) {
        this.numDocumentoCliente = numDocumentoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }
}
