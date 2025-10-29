package co.edu.unbosque.GYM_BD.controller;

import co.edu.unbosque.GYM_BD.model.dtos.ClienteDTO;
import co.edu.unbosque.GYM_BD.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasio/api")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        System.out.println("Lista de clientes");
        return new ResponseEntity<>(clienteService.buscarClientes(), HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteDTO cliente) {
        System.out.println("Cliente registrado");
        return new ResponseEntity<>(clienteService.registrarCliente(cliente), HttpStatus.CREATED);
    }
}
