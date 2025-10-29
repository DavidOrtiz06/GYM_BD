package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "entrenador")
public class Entrenador implements Serializable {

    @Id
    @Column(name = "NUM_DOC_ENTRENADOR")
    private String numDocumentoEntrenador;

    @Column(name = "NOMBRE_ENTRENADOR")
    private String nombre;

    @Column(name = "CORREO_ENTRENADOR")
    private String correo;

    @Column(name = "ESTADO_ENTRENADOR")
    private String estado;

    @Column(name = "NUM_TELEFONO_ENTRENADOR")
    private String numTelefono;

    @Column(name = "TURNO_ENTRENADOR")
    private String turno;

    @Column(name = "ANIOS_EXP_ENTRENADOR")
    private int aniosExp;

    @Column(name = "NIVEL_FORMACION_ENTRENADOR")
    private String nivelFormacion;

    public Entrenador() {}

    public String getNumDocumentoEntrenador() {
        return numDocumentoEntrenador;
    }

    public void setNumDocumentoEntrenador(String numDocumentoEntrenador) {
        this.numDocumentoEntrenador = numDocumentoEntrenador;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(int aniosExp) {
        this.aniosExp = aniosExp;
    }

    public String getNivelFormacion() {
        return nivelFormacion;
    }

    public void setNivelFormacion(String nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
    }
}
