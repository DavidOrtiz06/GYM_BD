package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ClienteDTO;
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

@Named("clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    private ClienteDTO clienteDto;

    @Inject
    private InterfaceService<ClienteDTO> clienteService;

    @PostConstruct
    public void init(){
        clienteDto = new ClienteDTO();
    }

    public void registrarCliente() throws JsonProcessingException {
        clienteService.registrar(clienteDto);
        clienteDto = new ClienteDTO();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "El cliente fue registrado correctamente", null));
    }

    public List<ClienteDTO> listarClientes(){
        return clienteService.listar();
    }
}
