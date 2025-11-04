package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.FisioterapeutaDTO;
import co.edu.unbosque.gym_bd1.services.interfaces.InterfaceFisioterapeuta;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("fisioterapeutaBean")
@ViewScoped
public class FisioterapeutaBean implements Serializable {

    private FisioterapeutaDTO fisioterapeutaDto;
    private List<Object[]> clientesPorFisioterapeuta;
    private String numDocumentoFisioterapeuta;

    @Inject
    private InterfaceFisioterapeuta fisioterapeutaService;
    @Inject
    private TablaBean tablaBean;

    @PostConstruct
    public void init() {
        fisioterapeutaDto = new FisioterapeutaDTO();
    }

    public void registrarFisioterapeuta() throws JsonProcessingException {
        fisioterapeutaService.registrar(fisioterapeutaDto);
        fisioterapeutaDto = new FisioterapeutaDTO();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Fisioterapeuta registrado correctamente.", null));
        if("fisioterapeuta".equals(tablaBean.getTipoActual())){
            tablaBean.listarEntidad("fisioterapeuta");
        }
    }

    public List<FisioterapeutaDTO> listarFisioterapeutas() throws JsonProcessingException {
        return fisioterapeutaService.listar();
    }

    public void crearFisioterapeuta() {
        System.out.println("Creando Fisioterapeuta");
    }

    public void obtenerClientesPorFisioterapeuta(String numDocumentoFisioterapeuta) throws JsonProcessingException {
        clientesPorFisioterapeuta = fisioterapeutaService.listarClientesPorFisioterapeuta(numDocumentoFisioterapeuta);
    }

    public FisioterapeutaDTO getFisioterapeutaDto() {
        return fisioterapeutaDto;
    }

    public void setFisioterapeutaDto(FisioterapeutaDTO fisioterapeutaDto) {
        this.fisioterapeutaDto = fisioterapeutaDto;
    }

    public List<Object[]> getClientesPorFisioterapeuta() {
        return clientesPorFisioterapeuta;
    }

    public void setClientesPorFisioterapeuta(List<Object[]> clientesPorFisioterapeuta) {
        this.clientesPorFisioterapeuta = clientesPorFisioterapeuta;
    }

    public String getNumDocumentoFisioterapeuta() {
        return numDocumentoFisioterapeuta;
    }

    public void setNumDocumentoFisioterapeuta(String numDocumentoFisioterapeuta) {
        this.numDocumentoFisioterapeuta = numDocumentoFisioterapeuta;
    }
}
