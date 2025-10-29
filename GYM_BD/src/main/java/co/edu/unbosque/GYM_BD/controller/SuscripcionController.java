package co.edu.unbosque.GYM_BD.controller;

import co.edu.unbosque.GYM_BD.model.dtos.SuscripcionDTO;
import co.edu.unbosque.GYM_BD.services.SuscripcionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasio/api")
public class SuscripcionController {

    private final SuscripcionService suscripcionService;

    public SuscripcionController(SuscripcionService suscripcionService) {
        this.suscripcionService = suscripcionService;
    }

    @GetMapping("/suscripciones")
    public ResponseEntity<List<SuscripcionDTO>> listarSuscripciones() {
        System.out.println("Lista de suscripciones");
        return new ResponseEntity<>(suscripcionService.buscarSuscripciones(), HttpStatus.OK);
    }

    @PostMapping("/suscripciones")
    public ResponseEntity<SuscripcionDTO> registrarSuscripcion(@RequestBody SuscripcionDTO suscripcion) {
        System.out.println("Suscripción registrada");
        return new ResponseEntity<>(suscripcionService.registrarSuscripcion(suscripcion), HttpStatus.CREATED);
    }
}
