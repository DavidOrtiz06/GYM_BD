package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "fisioterapeuta")
public class Fisioterapeuta implements Serializable {

    @Id
    @Column(name = "NUM_DOC_FISIOTERAPEUTA")
    private String numDocumentoFisioterapeuta;

    @Column(name = "NOMBRE_FISIOTERAPEUTA")
    private String nombre;

    @Column(name = "CORREO_FISIOTERAPEUTA")
    private String correo;

    @Column(name = "ESTADO_FISIOTERAPEUTA")
    private String estado;

    @Column(name = "NUM_TELEFONO_FISIOTERAPEUTA")
    private String numTelefono;

    @Column(name = "TURNO_FISIOTERAPEUTA")
    private String turno;

    @Column(name = "ANIOS_EXP_FISIOTERAPEUTA")
    private Integer aniosExp;

    @Column(name = "ESPECIALIDAD_FISIOTERAPEUTA")
    private String especialidad;

    @Column(name = "NUM_LICENCIA_FISIOTERAPEUTA")
    private String numLicencia;

    public Fisioterapeuta() {}

    public String getNumDocumentoFisioterapeuta() {
        return numDocumentoFisioterapeuta;
    }

    public void setNumDocumentoFisioterapeuta(String numDocumentoFisioterapeuta) {
        this.numDocumentoFisioterapeuta = numDocumentoFisioterapeuta;
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

    public Integer getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(Integer aniosExp) {
        this.aniosExp = aniosExp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }
}
