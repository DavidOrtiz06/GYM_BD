package co.edu.unbosque.gym_bd1.view;

import co.edu.unbosque.gym_bd1.model.ClienteDTO;
import co.edu.unbosque.gym_bd1.model.FisioterapeutaDTO;
import co.edu.unbosque.gym_bd1.model.ValoracionDTO;
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

@Named("valoracionBean")
@ViewScoped
public class ValoracionBean implements Serializable {

    private ValoracionDTO valoracionDto;
    private ClienteDTO clienteDto;
    private FisioterapeutaDTO fisioterapeutaDto;
    private String restricciones;

    @Inject
    private InterfaceService<ValoracionDTO, Integer> valoracionService;
    @Inject
    private TablaBean tablaBean;

    @PostConstruct
    public void init() {
        valoracionDto = new ValoracionDTO();
        clienteDto = new ClienteDTO();
        fisioterapeutaDto = new FisioterapeutaDTO();
    }

    public void registrarValoracion() throws JsonProcessingException {
        valoracionDto.setCliente(clienteDto);
        valoracionDto.setFisioterapeuta(fisioterapeutaDto);
        valoracionService.registrar(valoracionDto);
        valoracionDto = new ValoracionDTO();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Valoración registrada correctamente.", null));
        if("valoracion".equals(tablaBean.getTipoActual())){
            tablaBean.listarEntidad("valoracion");
        }
    }

    public List<ValoracionDTO> listarValoraciones() throws JsonProcessingException {
        return valoracionService.listar();
    }

    public void actualizarValoracion() throws JsonProcessingException {
        if(valoracionDto.getEstado().equals("Pendiente")){
            valoracionDto.setEstado("Completada");
            valoracionDto.setRestricciones(restricciones);
            valoracionService.actualizar(valoracionDto, valoracionDto.getIdValoracion());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Valoracion actualizada y completada", null));
            valoracionDto = new ValoracionDTO();
        }
    }

    public void actualizar(ValoracionDTO valoracion) {
        valoracionDto = valoracion;
        System.out.println("Actualizando valoracion");
    }

    public void crearValoracion(){
        System.out.println("Creando Valoracion");
    }

    public ValoracionDTO getValoracionDto() {
        return valoracionDto;
    }

    public void setValoracionDto(ValoracionDTO valoracionDto) {
        this.valoracionDto = valoracionDto;
    }

    public ClienteDTO getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDTO clienteDto) {
        this.clienteDto = clienteDto;
    }

    public FisioterapeutaDTO getFisioterapeutaDto() {
        return fisioterapeutaDto;
    }

    public void setFisioterapeutaDto(FisioterapeutaDTO fisioterapeutaDto) {
        this.fisioterapeutaDto = fisioterapeutaDto;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }
}
