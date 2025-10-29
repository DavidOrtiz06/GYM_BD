package co.edu.unbosque.GYM_BD.services;

import co.edu.unbosque.GYM_BD.model.entities.Entrenador;
import co.edu.unbosque.GYM_BD.model.dtos.EntrenadorDTO;
import co.edu.unbosque.GYM_BD.repositories.EntrenadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public List<EntrenadorDTO> buscarEntrenadores() {
        List<EntrenadorDTO> listaEntrenadores = new ArrayList<>();
        List<Entrenador> entrenadoresBD = entrenadorRepository.findAll();
        for (Entrenador entrenador : entrenadoresBD) {
            listaEntrenadores.add(modelMapper.map(entrenador, EntrenadorDTO.class));
        }
        return listaEntrenadores;
    }

    public EntrenadorDTO registrarEntrenador(EntrenadorDTO entrenador) {
        entrenador.setEstado("Activo");
        return modelMapper.map(entrenadorRepository.save(modelMapper.map(entrenador, Entrenador.class)), EntrenadorDTO.class);
    }
}
