package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ClienteDTO;
import co.edu.unbosque.gym_bd1.model.SuscripcionDTO;
import co.edu.unbosque.gym_bd1.services.InterfaceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    private ClienteDTO clienteDto;
    private SuscripcionDTO suscripcionDto;
    private List<ClienteDTO> clientesFiltrados;
    private String idClienteFiltro;

    @Inject
    private SuscripcionBean suscripcionBean;
    @Inject
    private InterfaceService<ClienteDTO, String> clienteService;
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
        clientesFiltrados = listarClientes();
    }

    public List<ClienteDTO> listarClientes() throws JsonProcessingException {
        return clienteService.listar();
    }

    public void buscarClientes() throws JsonProcessingException {
        List<ClienteDTO> todosClientes = clienteService.listar();

        clientesFiltrados = todosClientes.stream()
                .filter(c -> idClienteFiltro == null || idClienteFiltro.isEmpty() ||
                        (c.getNumDocumentoCliente() != null &&
                                c.getNumDocumentoCliente().equals(idClienteFiltro)))
                .collect(Collectors.toList());
    }

    public ClienteDTO getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDTO clienteDto) {
        this.clienteDto = clienteDto;
    }

    public List<ClienteDTO> getClientesFiltrados() throws JsonProcessingException {
        if(clientesFiltrados == null){
            clientesFiltrados = listarClientes();
        }
        return clientesFiltrados;
    }

    public void setClientesFiltrados(List<ClienteDTO> clientesFiltrados) {
        this.clientesFiltrados = clientesFiltrados;
    }

    public SuscripcionDTO getSuscripcionDto() {
        return suscripcionDto;
    }

    public void setSuscripcionDto(SuscripcionDTO suscripcionDto) {
        this.suscripcionDto = suscripcionDto;
    }

    public String getIdClienteFiltro() {
        return idClienteFiltro;
    }

    public void setIdClienteFiltro(String idClienteFiltro) {
        this.idClienteFiltro = idClienteFiltro;
    }
}
