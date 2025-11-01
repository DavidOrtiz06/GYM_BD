package co.edu.unbosque.gym_bd1.model;

import java.io.Serializable;

public class ActualizarValoracionDTO implements Serializable {

    private String estado;
    private String restricciones;

    public ActualizarValoracionDTO() {}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }
}
