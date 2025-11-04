package co.edu.unbosque.gym_bd1.services.interfaces;

import co.edu.unbosque.gym_bd1.model.FisioterapeutaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceFisioterapeuta extends InterfaceService<FisioterapeutaDTO> {

    List<Object[]> listarClientesPorFisioterapeuta(String numDocumentoFisioterapeuta) throws JsonProcessingException;
}
