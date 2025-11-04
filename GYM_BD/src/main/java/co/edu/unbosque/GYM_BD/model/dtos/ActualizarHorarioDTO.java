package co.edu.unbosque.GYM_BD.model.dtos;

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
