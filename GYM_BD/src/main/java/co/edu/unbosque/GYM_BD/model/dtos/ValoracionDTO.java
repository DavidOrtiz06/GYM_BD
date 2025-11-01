package co.edu.unbosque.GYM_BD.model.dtos;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ValoracionDTO {

    private Integer idValoracion;
    private LocalDateTime fecha;
    private LocalTime hora;
    private String estado;
    private ClienteDTO cliente;
    private FisioterapeutaDTO fisioterapeuta;
    private String restricciones;

    public ValoracionDTO() {}

    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public FisioterapeutaDTO getFisioterapeuta() {
        return fisioterapeuta;
    }

    public void setFisioterapeuta(FisioterapeutaDTO fisioterapeuta) {
        this.fisioterapeuta = fisioterapeuta;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }
}
