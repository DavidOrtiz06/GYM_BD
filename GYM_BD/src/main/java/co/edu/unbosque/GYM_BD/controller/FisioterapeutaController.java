package co.edu.unbosque.GYM_BD.controller;

import co.edu.unbosque.GYM_BD.model.dtos.FisioterapeutaDTO;
import co.edu.unbosque.GYM_BD.services.FisioterapeutaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasio/api")
public class FisioterapeutaController {

    private final FisioterapeutaService fisioterapeutaService;

    public FisioterapeutaController(FisioterapeutaService fisioterapeutaService) {
        this.fisioterapeutaService = fisioterapeutaService;
    }

    @GetMapping("/fisioterapeutas")
    public ResponseEntity<List<FisioterapeutaDTO>> listarFisioterapeutas() {
        System.out.println("Lista de fisioterapeutas");
        return new ResponseEntity<>(fisioterapeutaService.buscarFisioterapeutas(), HttpStatus.OK);
    }

    @PostMapping("/fisioterapeutas")
    public ResponseEntity<FisioterapeutaDTO> registrarFisioterapeuta(@RequestBody FisioterapeutaDTO fisioterapeuta) {
        System.out.println("Fisioterapeuta registrado");
        return new ResponseEntity<>(fisioterapeutaService.registrarFisioterapeuta(fisioterapeuta), HttpStatus.CREATED);
    }

    @GetMapping("/fisioterapeutas/{numDocumentoFisioterapeuta}")
    public ResponseEntity<List<Object[]>> obtenerClientesPorFisioterapeuta( @PathVariable String numDocumentoFisioterapeuta) {
        System.out.println("Lista de clientes atendidos por fisioterapeuta: " + numDocumentoFisioterapeuta);
        return new ResponseEntity<>(fisioterapeutaService.obtenerClientesPorFisioterapeuta(numDocumentoFisioterapeuta), HttpStatus.OK);
    }
}
