package co.edu.unbosque.gym_bd1.model;

import java.io.Serializable;

public class ActualizarHorarioDTO implements Serializable {

    private Integer cupo;

    public ActualizarHorarioDTO() {}

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }
}
