package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "clase")
public class Clase implements Serializable {

    @Id
    @Column(name = "ID_CLASE")
    private Integer idClase;

    @Column(name = "NOMBRE_CLASE")
    private String nombre;

    @Column(name = "DURACION_CLASE")
    private String duracion;

    @ManyToOne
    @JoinColumn(name = "NUM_DOC_ENTRENADOR")
    private Entrenador entrenador;

    public Clase() {}

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
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

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
