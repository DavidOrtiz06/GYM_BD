package co.edu.unbosque.GYM_BD.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "valoracion")
public class Valoracion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VALORACION")
    private int idValoracion;

    @Column(name = "FECHA_VALORACION")
    private LocalDateTime fecha;

    @Column(name = "HORA_VALORACION")
    private LocalTime hora;

    @Column(name = "ESTADO_VALORACION")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "NUM_DOC_CLIENTE")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "NUM_DOC_FISIOTERAPEUTA")
    private Fisioterapeuta fisioterapeuta;

    @Column(name = "RESTRICCIONES")
    private String restricciones;

    public Valoracion() {}

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fisioterapeuta getFisioterapeuta() {
        return fisioterapeuta;
    }

    public void setFisioterapeuta(Fisioterapeuta fisioterapeuta) {
        this.fisioterapeuta = fisioterapeuta;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }
}
