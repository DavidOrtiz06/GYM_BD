package co.edu.unbosque.gym_bd1.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("tablaBean")
@ViewScoped
public class TablaBean implements Serializable {

    private String tipoActual;
    private List<?> tablaDatos;

    @Inject
    private ClienteBean clienteBean;
    @Inject
    private FisioterapeutaBean fisioterapeutaBean;
    @Inject
    private EntrenadorBean entrenadorBean;
    @Inject
    private SuscripcionBean suscripcionBean;
    @Inject
    private ValoracionBean valoracionBean;
    @Inject
    private HorarioBean horarioBean;

    @PostConstruct
    public void init() {
        try {
            tipoActual = "cliente";
            tablaDatos = clienteBean.listarClientes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            tablaDatos = List.of();
        }
    }

    public void listarEntidad(String entidad) throws JsonProcessingException {
        tipoActual = entidad;
        switch (tipoActual) {
            case "cliente":
                tablaDatos = clienteBean.listarClientes();
                break;
            case "fisioterapeuta":
                tablaDatos = fisioterapeutaBean.listarFisioterapeutas();
                break;
            case "entrenador":
                tablaDatos = entrenadorBean.listarEntrenadores();
                break;
            case "suscripcion":
                tablaDatos = suscripcionBean.listarSuscripciones();
                break;
            case "valoracion":
                tablaDatos = valoracionBean.listarValoraciones();
                break;
            case "horario":
                tablaDatos = horarioBean.listarHorarios();
                break;
        }
    }

    public String getTipoActual() {
        return tipoActual;
    }

    public void setTipoActual(String tipoActual) {
        this.tipoActual = tipoActual;
    }

    public List<?> getTablaDatos() {
        return tablaDatos;
    }

    public void setTablaDatos(List<?> tablaDatos) {
        this.tablaDatos = tablaDatos;
    }
}
