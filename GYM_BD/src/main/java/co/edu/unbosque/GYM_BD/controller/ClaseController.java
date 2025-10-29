package co.edu.unbosque.GYM_BD.controller;

import co.edu.unbosque.GYM_BD.model.dtos.ClaseDTO;
import co.edu.unbosque.GYM_BD.services.ClaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasio/api")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping("/clases")
    public ResponseEntity<List<ClaseDTO>> listarClases() {
        System.out.println("Lista de clases");
        return new ResponseEntity<>(claseService.buscarClases(), HttpStatus.OK);
    }

    @PostMapping("/clases")
    public ResponseEntity<ClaseDTO> registrarClase(@RequestBody ClaseDTO clase) {
        System.out.println("Clase registrada");
        return new ResponseEntity<>(claseService.registrarClase(clase), HttpStatus.CREATED);
    }
}
