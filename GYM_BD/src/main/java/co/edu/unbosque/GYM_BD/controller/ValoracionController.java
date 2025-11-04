package co.edu.unbosque.GYM_BD.controller;

import co.edu.unbosque.GYM_BD.model.dtos.ValoracionDTO;
import co.edu.unbosque.GYM_BD.services.ValoracionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/gimnasio/api")
public class ValoracionController {

    private final ValoracionService valoracionService;

    public ValoracionController(ValoracionService valoracionService) {
        this.valoracionService = valoracionService;
    }

    @GetMapping("/valoraciones")
    public ResponseEntity<List<ValoracionDTO>> listarValoraciones() {
        System.out.println("Lista de valoraciones");
        return new ResponseEntity<>(valoracionService.buscarValoraciones(), HttpStatus.OK);
    }

    @PostMapping("/valoraciones")
    public ResponseEntity<ValoracionDTO> registrarValoracion(@RequestBody ValoracionDTO valoracion) {
        System.out.println("Valoración registrada");
        return new ResponseEntity<>(valoracionService.registrarValoracion(valoracion), HttpStatus.CREATED);
    }

    @PutMapping("/valoraciones/{idValoracion}/estado")
    public ResponseEntity<ValoracionDTO> actualizarValoracion(@PathVariable Integer idValoracion, @RequestBody ValoracionDTO valoracion) {
        System.out.println("Valoracion actualizada");
        return new ResponseEntity<>(valoracionService.actualizarValoracion(idValoracion, valoracion.getEstado(), valoracion.getRestricciones()), HttpStatus.CREATED);
    }

    @GetMapping("/valoraciones/estado/{estado}")
    public ResponseEntity<List<Object[]>> obtenerValoracionesPorEstado(@PathVariable String estado) {
        System.out.println("Lista de valoraciones " + estado + "s");
        return new ResponseEntity<>(valoracionService.obtenerValoracionesPorEstado(estado), HttpStatus.OK);
    }

    @GetMapping("/valoraciones/fecha/{fecha}")
    public ResponseEntity<List<Object[]>> obtenerValoracionesPorFecha(@PathVariable LocalDate fecha) {
        System.out.println("Lista de valoraciones de la fecha: " + fecha);
        return new ResponseEntity<>(valoracionService.obtenerValoracionesPorFecha(fecha), HttpStatus.OK);
    }
}
