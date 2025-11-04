package co.edu.unbosque.GYM_BD.controller;

import co.edu.unbosque.GYM_BD.model.dtos.IngresoDTO;
import co.edu.unbosque.GYM_BD.services.IngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasio/api")
public class IngresoController {

    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @GetMapping("/ingresos")
    public ResponseEntity<List<IngresoDTO>> listarIngresos() {
        System.out.println("Lista de Ingresos");
        return new ResponseEntity<>(ingresoService.buscarIngresos(), HttpStatus.OK);
    }

    @PostMapping("/ingresos")
    public ResponseEntity<IngresoDTO> registrarIngreso(@RequestBody IngresoDTO ingreso) {
        System.out.println("Ingreso Registrado");
        return new ResponseEntity<>(ingresoService.registrarIngreso(ingreso), HttpStatus.CREATED);
    }
}
