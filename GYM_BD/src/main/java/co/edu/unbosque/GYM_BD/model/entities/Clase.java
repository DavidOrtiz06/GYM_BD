package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "clase")
public class Clase implements Serializable {

    @Id
    @Column(name = "ID_CLASE")
    private int idClase;

    @Column(name = "NOMBRE_CLASE")
    private String nombre;

    @Column(name = "DURACION_CLASE")
    private String duracion;

    @Column(name = "CUPO_CLASE")
    private int cupo;

    @ManyToOne
    @JoinColumn(name = "NUM_DOC_ENTRENADOR")
    private Entrenador entrenador;

    public Clase() {}

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
