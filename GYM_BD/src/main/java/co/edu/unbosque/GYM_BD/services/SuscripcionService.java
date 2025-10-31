package co.edu.unbosque.GYM_BD.services;

import co.edu.unbosque.GYM_BD.model.entities.Suscripcion;
import co.edu.unbosque.GYM_BD.model.dtos.SuscripcionDTO;
import co.edu.unbosque.GYM_BD.repositories.SuscripcionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public SuscripcionService(SuscripcionRepository suscripcionRepository) {
        this.suscripcionRepository = suscripcionRepository;
    }

    public List<SuscripcionDTO> buscarSuscripciones() {
        List<SuscripcionDTO> listaSuscripciones = new ArrayList<>();
        List<Suscripcion> suscripcionesBD = suscripcionRepository.findAll();
        for (Suscripcion s : suscripcionesBD) {
            listaSuscripciones.add(modelMapper.map(s, SuscripcionDTO.class));
        }
        return listaSuscripciones;
    }

    public SuscripcionDTO registrarSuscripcion(SuscripcionDTO suscripcion) {
        suscripcion.setEstado("Activo");
        suscripcion.setFechaInicio(LocalDateTime.now());
        suscripcion.setFechaFin(suscripcion.getFechaInicio().plusMonths(suscripcion.getMeses()));
        return modelMapper.map(suscripcionRepository.save(modelMapper.map(suscripcion, Suscripcion.class)), SuscripcionDTO.class);
    }
}
