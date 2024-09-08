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
    @GetMapping("/todos")//TRAE TODOS LOS CLIENTES
    @Operation(summary = "Trae todos los clientes", description = "Trae a todos los clientes y NO usa parametros")
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }
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
    @Operation(summary = "Borra Cliente por Id", description = "Borra un cliente colocando un Id valido")

    public ResponseEntity<String> borrarCliente(@PathVariable Long id) {
        try {
            clienteService.borrarCliente(id);
            return new ResponseEntity<>("Cliente borrado correctamente", HttpStatus.OK);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PutMapping("/actualizar/{id}")
    @Operation(summary = "Actualiza Cliente por Id", description = "Actualiza un cliente colocando un Id valido")

    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        try {
            Cliente cliente =  clienteService.actualizarCliente(id, clienteActualizado);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }




}


