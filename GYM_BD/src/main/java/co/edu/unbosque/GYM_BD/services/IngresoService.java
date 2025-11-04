package co.edu.unbosque.GYM_BD.services;

import co.edu.unbosque.GYM_BD.model.dtos.IngresoDTO;
import co.edu.unbosque.GYM_BD.model.entities.Ingreso;
import co.edu.unbosque.GYM_BD.repositories.IngresoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngresoService {

    private final IngresoRepository ingresoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public IngresoService(IngresoRepository ingresoRepository) {
        this.ingresoRepository = ingresoRepository;
    }

    public List<IngresoDTO> buscarIngresos() {
        List<IngresoDTO> listaIngresos = new ArrayList<>();
        List<Ingreso> ingresosBD = ingresoRepository.findAll();
        for (Ingreso ingreso : ingresosBD) {
            listaIngresos.add(modelMapper.map(ingreso, IngresoDTO.class));
        }
        return listaIngresos;
    }

    public IngresoDTO registrarIngreso(IngresoDTO ingreso) {
        return modelMapper.map(ingresoRepository.save(modelMapper.map(ingreso, Ingreso.class)),IngresoDTO.class);
    }
}
