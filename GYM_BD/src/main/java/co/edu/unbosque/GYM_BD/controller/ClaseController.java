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

    @GetMapping("/clases/{cupo}")
    public ResponseEntity<List<Object[]>> obtenerClasesConCupoMayorA(@PathVariable Integer cupo) {
        System.out.println("Lista de clases con cupo mayor a: " + cupo);
        return new ResponseEntity<>(claseService.obtenerClasesConCupoMayorA(cupo), HttpStatus.OK);
    }

    @GetMapping("/clases/{duracion}/{cupo}")
    public ResponseEntity<List<Object[]>> obtenerClasesPorTiempoYCupo(@PathVariable Integer duracion, @PathVariable Integer cupo) {
        System.out.println("Lista de clases por duración de: " + duracion + " y cupo de: " + cupo);
        return new ResponseEntity<>(claseService.obtenerClasesPorTiempoYCupo(duracion, cupo), HttpStatus.OK);
    }
}
