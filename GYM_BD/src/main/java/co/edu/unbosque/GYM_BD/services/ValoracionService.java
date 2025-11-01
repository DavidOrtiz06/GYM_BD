package co.edu.unbosque.GYM_BD.services;

import co.edu.unbosque.GYM_BD.model.entities.Valoracion;
import co.edu.unbosque.GYM_BD.model.dtos.ValoracionDTO;
import co.edu.unbosque.GYM_BD.repositories.ValoracionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValoracionService {

    private final ValoracionRepository valoracionRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public ValoracionService(ValoracionRepository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }

    public List<ValoracionDTO> buscarValoraciones() {
        List<ValoracionDTO> listaValoraciones = new ArrayList<>();
        List<Valoracion> valoracionesBD = valoracionRepository.findAll();
        for (Valoracion v : valoracionesBD) {
            listaValoraciones.add(modelMapper.map(v, ValoracionDTO.class));
        }
        return listaValoraciones;
    }

    public ValoracionDTO registrarValoracion(ValoracionDTO valoracion) {
        valoracion.setEstado("Pendiente");
        return modelMapper.map(valoracionRepository.save(modelMapper.map(valoracion, Valoracion.class)), ValoracionDTO.class);
    }

    public ValoracionDTO actualizarValoracion(Integer idValoracion, String estado, String restricciones) {
        Valoracion valoracion = valoracionRepository.findById(idValoracion).get();
        valoracion.setEstado(estado);
        valoracion.setRestricciones(restricciones);
        return modelMapper.map(valoracionRepository.save(valoracion), ValoracionDTO.class);
    }
}
