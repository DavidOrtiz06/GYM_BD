package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ingreso")
public class Ingreso implements Serializable {

    @EmbeddedId
    private IngresoId id;

    @ManyToOne
    @MapsId("numDocCliente")
    @JoinColumn(name = "NUM_DOC_CLIENTE")
    private Cliente cliente;

    @ManyToOne
    @MapsId("idClase")
    @JoinColumn(name = "ID_CLASE")
    private Clase clase;

    public Ingreso() {}

    public IngresoId getId() {
        return id;
    }

    public void setId(IngresoId id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
