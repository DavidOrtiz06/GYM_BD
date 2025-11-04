package co.edu.unbosque.GYM_BD.services;

import co.edu.unbosque.GYM_BD.model.entities.Fisioterapeuta;
import co.edu.unbosque.GYM_BD.model.dtos.FisioterapeutaDTO;
import co.edu.unbosque.GYM_BD.repositories.FisioterapeutaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FisioterapeutaService {

    private final FisioterapeutaRepository fisioterapeutaRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public FisioterapeutaService(FisioterapeutaRepository fisioterapeutaRepository) {
        this.fisioterapeutaRepository = fisioterapeutaRepository;
    }

    public List<FisioterapeutaDTO> buscarFisioterapeutas() {
        List<FisioterapeutaDTO> listaFisioterapeutas = new ArrayList<>();
        List<Fisioterapeuta> fisioterapeutasBD = fisioterapeutaRepository.findAll();
        for (Fisioterapeuta f : fisioterapeutasBD) {
            listaFisioterapeutas.add(modelMapper.map(f, FisioterapeutaDTO.class));
        }
        return listaFisioterapeutas;
    }

    public FisioterapeutaDTO registrarFisioterapeuta(FisioterapeutaDTO fisioterapeuta) {
        fisioterapeuta.setEstado("Activo");
        fisioterapeuta.setCorreo(fisioterapeuta.getNombre().replace(" ", ".").toLowerCase() + "@gymfit.com");
        return modelMapper.map(fisioterapeutaRepository.save(modelMapper.map(fisioterapeuta, Fisioterapeuta.class)), FisioterapeutaDTO.class);
    }

    public List<Object[]> obtenerClientesPorFisioterapeuta(String numDocumentoFisioterapeuta) {
        return fisioterapeutaRepository.obtenerClientesPorFisioterapeuta(numDocumentoFisioterapeuta);
    }
}
