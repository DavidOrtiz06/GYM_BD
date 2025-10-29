package co.edu.unbosque.GYM_BD.model.dtos;

public class FisioterapeutaDTO {

    private String numDocumentoFisioterapeuta;
    private String nombre;
    private String correo;
    private String estado;
    private String numTelefono;
    private String turno;
    private int aniosExp;
    private String especialidad;
    private int numLicencia;

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

    public int getAniosExp() {
        return aniosExp;
    }

    public void setAniosExp(int aniosExp) {
        this.aniosExp = aniosExp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(int numLicencia) {
        this.numLicencia = numLicencia;
    }
}
