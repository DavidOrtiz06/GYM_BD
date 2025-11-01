package co.edu.unbosque.gym_bd1.model;

public class FisioterapeutaDTO {

    private String numDocumentoFisioterapeuta;
    private String nombre;
    private String correo;
    private String estado;
    private String numTelefono;
    private String turno;
    private Integer aniosExp;
    private String especialidad;
    private String numLicencia;

    public FisioterapeutaDTO() {}

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
