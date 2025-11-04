package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IngresoId implements Serializable {

    private String numDocCliente;
    private Integer idClase;

    public IngresoId() {}

    public IngresoId(String numDocCliente, Integer idClase) {
        this.numDocCliente = numDocCliente;
        this.idClase = idClase;
    }

    public String getNumDocCliente() {
        return numDocCliente;
    }

    public void setNumDocCliente(String numDocCliente) {
        this.numDocCliente = numDocCliente;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngresoId)) return false;
        IngresoId that = (IngresoId) o;
        return idClase == that.idClase &&
                Objects.equals(numDocCliente, that.numDocCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numDocCliente, idClase);
    }
}