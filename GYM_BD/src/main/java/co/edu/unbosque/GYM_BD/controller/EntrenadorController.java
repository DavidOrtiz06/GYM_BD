package co.edu.unbosque.GYM_BD.controller;

import co.edu.unbosque.GYM_BD.model.dtos.EntrenadorDTO;
import co.edu.unbosque.GYM_BD.services.EntrenadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasio/api")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/entrenadores")
    public ResponseEntity<List<EntrenadorDTO>> listarEntrenadores() {
        System.out.println("Lista de entrenadores");
        return new ResponseEntity<>(entrenadorService.buscarEntrenadores(), HttpStatus.OK);
    }

    @PostMapping("/entrenadores")
    public ResponseEntity<EntrenadorDTO> registrarEntrenador(@RequestBody EntrenadorDTO entrenador) {
        System.out.println("Entrenador registrado");
        return new ResponseEntity<>(entrenadorService.registrarEntrenador(entrenador), HttpStatus.CREATED);
    }

    @GetMapping("/entrenadores/{turno}")
    public ResponseEntity<List<Object[]>> obtenerEntrenadorPorTurno(@PathVariable String turno) {
        System.out.println("Lista de entrenadores en turno: " + turno);
        return new ResponseEntity<>(entrenadorService.obtenerEntrenadoresPorTurno(turno), HttpStatus.OK);
    }
}
