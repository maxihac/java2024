package edu.coderhouse.FacturacionPrimeraEntrega.controller;

import edu.coderhouse.FacturacionPrimeraEntrega.model.Cliente;

import edu.coderhouse.FacturacionPrimeraEntrega.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Cliente",description = "Operaciones con  clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/agregar")
    @Operation(summary = "Agregar Nuevo Cliente", description = "Agrega un nuevo Cliente al sistema")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.agregarCliente(cliente);
    }
    @GetMapping("/todos")     //TRAE TODOS LOS CLIENTES
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }
//    @GetMapping("/buscar/{id}")
//    public Optional<Cliente> buscarCliente(@PathVariable Long id) {
//        return clienteService.buscarCliente(id);
//    }

    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar Cliente por Id", description = "Busca una cliente colocando un Id valido")

    public ResponseEntity<?> buscarCliente(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.buscarCliente(id);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarCliente(@PathVariable Long id) {
        clienteService.borrarCliente(id);
        return new ResponseEntity<>("Cliente borrado correctamente", HttpStatus.OK);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        Cliente cliente = clienteService.actualizarCliente(id, clienteActualizado);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

}


