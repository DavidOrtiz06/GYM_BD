package co.edu.unbosque.gym_bd1.model;

public class EntrenadorDTO {

    private String numDocumentoEntrenador;
    private String nombre;
    private String correo;
    private String estado;
    private String numTelefono;
    private String turno;
    private int aniosExp;
    private String nivelFormacion;

    public EntrenadorDTO() {}

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
