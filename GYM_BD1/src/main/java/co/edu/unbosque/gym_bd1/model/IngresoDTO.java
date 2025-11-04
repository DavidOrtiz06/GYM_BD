package co.edu.unbosque.gym_bd1.model;

public class IngresoDTO {

    private ClienteDTO cliente;
    private ClaseDTO clase;

    public IngresoDTO() {}

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ClaseDTO getClase() {
        return clase;
    }

    public void setClase(ClaseDTO clase) {
        this.clase = clase;
    }
}
