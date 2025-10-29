package co.edu.unbosque.GYM_BD.model.dtos;

public class ClienteDTO {

    private String numDocumentoCliente;
    private String nombre;
    private String correo;
    private String estado;
    private String numTelefono;
    private SuscripcionDTO suscripcion;

    public ClienteDTO(){}

    public String getNumDocumentoCliente() {
        return numDocumentoCliente;
    }

    public void setNumDocumentoCliente(String numDocumentoCliente) {
        this.numDocumentoCliente = numDocumentoCliente;
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

    public SuscripcionDTO getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(SuscripcionDTO suscripcion) {
        this.suscripcion = suscripcion;
    }
}
