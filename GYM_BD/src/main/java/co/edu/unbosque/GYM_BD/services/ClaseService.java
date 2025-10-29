package co.edu.unbosque.GYM_BD.services;

import co.edu.unbosque.GYM_BD.model.dtos.ClaseDTO;
import co.edu.unbosque.GYM_BD.model.entities.Clase;
import co.edu.unbosque.GYM_BD.repositories.ClaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaseService {

    private final ClaseRepository claseRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public ClaseService(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    public List<ClaseDTO> buscarClases() {
        List<ClaseDTO> listaClases = new ArrayList<>();
        List<Clase> clasesBD = claseRepository.findAll();
        for (Clase clase : clasesBD) {
            listaClases.add(modelMapper.map(clase, ClaseDTO.class));
        }
        return listaClases;
    }

    public ClaseDTO registrarClase(ClaseDTO clase) {
        return modelMapper.map(claseRepository.save(modelMapper.map(clase, Clase.class)), ClaseDTO.class);
    }
}
