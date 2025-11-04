package co.edu.unbosque.GYM_BD.services;

import co.edu.unbosque.GYM_BD.model.entities.Horario;
import co.edu.unbosque.GYM_BD.model.dtos.HorarioDTO;
import co.edu.unbosque.GYM_BD.repositories.HorarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<HorarioDTO> buscarHorarios() {
        List<HorarioDTO> listaHorarios = new ArrayList<>();
        List<Horario> horariosBD = horarioRepository.findAll();
        for (Horario h : horariosBD) {
            listaHorarios.add(modelMapper.map(h, HorarioDTO.class));
        }
        return listaHorarios;
    }

    public HorarioDTO registrarHorario(HorarioDTO horario) {
        return modelMapper.map(horarioRepository.save(modelMapper.map(horario, Horario.class)), HorarioDTO.class);
    }

    public HorarioDTO actualizarHorario(Integer idHorario, Integer cupo) {
        Horario horario = horarioRepository.findById(idHorario).get();
        horario.setCupo(cupo);
        return modelMapper.map(horarioRepository.save(horario), HorarioDTO.class);
    }

    public List<Object[]> obtenerHorariosPorClase(String clase) {
        return horarioRepository.obtenerHorariosPorClase(clase);
    }
}
