package co.edu.unbosque.GYM_BD.controller;

import co.edu.unbosque.GYM_BD.model.dtos.HorarioDTO;
import co.edu.unbosque.GYM_BD.services.HorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasio/api")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping("/horarios")
    public ResponseEntity<List<HorarioDTO>> listarHorarios() {
        System.out.println("Lista de horarios");
        return new ResponseEntity<>(horarioService.buscarHorarios(), HttpStatus.OK);
    }

    @PostMapping("/horarios")
    public ResponseEntity<HorarioDTO> registrarHorario(@RequestBody HorarioDTO horario) {
        System.out.println("Horario registrado");
        return new ResponseEntity<>(horarioService.registrarHorario(horario), HttpStatus.CREATED);
    }

    @PutMapping("/horarios/{idHorario}/cupo")
    public ResponseEntity<HorarioDTO> actualizarHorario(@PathVariable Integer idHorario, @RequestBody HorarioDTO horario) {
        System.out.println("Horario actualizado");
        return new ResponseEntity<>(horarioService.actualizarHorario(idHorario, horario.getCupo()), HttpStatus.CREATED);
    }

    @GetMapping("/horarios/{clase}")
    public ResponseEntity<List<Object[]>> obtenerHorariosPorClase(@PathVariable String clase) {
        System.out.println("Lista de horarios de la clase: " + clase);
        return new ResponseEntity<>(horarioService.obtenerHorariosPorClase(clase), HttpStatus.OK);
    }
}
