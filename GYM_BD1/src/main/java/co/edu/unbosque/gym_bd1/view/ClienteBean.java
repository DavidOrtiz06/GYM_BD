package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ClienteDTO;
import co.edu.unbosque.gym_bd1.model.SuscripcionDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceCliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    private ClienteDTO clienteDto;
    private SuscripcionDTO suscripcionDto;
    private List<Object[]> clientesConMultiplesClases;
    private Integer totalClases;

    @Inject
    private SuscripcionBean suscripcionBean;
    @Inject
    private InterfaceCliente clienteService;
    @Inject
    private TablaBean tablaBean;

    @PostConstruct
    public void init(){
        clienteDto = new ClienteDTO();
        suscripcionDto = new SuscripcionDTO();
    }

    public void registrarCliente() throws JsonProcessingException {
        suscripcionDto = suscripcionBean.obtenerUltimaSuscripcion();
        if(suscripcionDto != null) {
            clienteDto.setSuscripcion(suscripcionDto);
        }
        clienteService.registrar(clienteDto);
        clienteDto = new ClienteDTO();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente registrado correctamente.", null));
        if("cliente".equals(tablaBean.getTipoActual())){
            tablaBean.listarEntidad("cliente");
        }
    }

    public List<ClienteDTO> listarClientes() throws JsonProcessingException {
        return clienteService.listar();
    }

    public void obtenerClientesClases(Integer totalClases) throws JsonProcessingException {
        clientesConMultiplesClases = clienteService.listarCLientesConMultiplesHorarios(totalClases);
    }

    public ClienteDTO getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDTO clienteDto) {
        this.clienteDto = clienteDto;
    }

    public SuscripcionDTO getSuscripcionDto() {
        return suscripcionDto;
    }

    public void setSuscripcionDto(SuscripcionDTO suscripcionDto) {
        this.suscripcionDto = suscripcionDto;
    }

    public List<Object[]> getClientesConMultiplesClases() {
        return clientesConMultiplesClases;
    }

    public void setClientesConMultiplesClases(List<Object[]> clientesConMultiplesClases) {
        this.clientesConMultiplesClases = clientesConMultiplesClases;
    }

    public Integer getTotalClases() {
        return totalClases;
    }

    public void setTotalClases(Integer totalClases) {
        this.totalClases = totalClases;
    }
}
