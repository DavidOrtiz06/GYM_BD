package co.edu.unbosque.GYM_BD.model.dtos;

public class ClaseDTO {

    private Integer idClase;
    private String nombre;
    private String duracion;
    private EntrenadorDTO entrenador;

    public ClaseDTO() {}

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

    public EntrenadorDTO getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(EntrenadorDTO entrenador) {
        this.entrenador = entrenador;
    }
}
