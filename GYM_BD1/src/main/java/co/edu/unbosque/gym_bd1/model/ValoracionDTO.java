package co.edu.unbosque.gym_bd1.model;

import java.util.Date;

public class ValoracionDTO {

    private int idValoracion;
    private Date fecha;
    private String hora;
    private String estado;
    private ClienteDTO numDocumentoCliente;
    private FisioterapeutaDTO numDocumentoFisioterapeuta;
    private String restricciones;

    public ValoracionDTO() {}

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClienteDTO getNumDocumentoCliente() {
        return numDocumentoCliente;
    }

    public void setNumDocumentoCliente(ClienteDTO numDocumentoCliente) {
        this.numDocumentoCliente = numDocumentoCliente;
    }

    public FisioterapeutaDTO getNumDocumentoFisioterapeuta() {
        return numDocumentoFisioterapeuta;
    }

    public void setNumDocumentoFisioterapeuta(FisioterapeutaDTO numDocumentoFisioterapeuta) {
        this.numDocumentoFisioterapeuta = numDocumentoFisioterapeuta;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }
}
