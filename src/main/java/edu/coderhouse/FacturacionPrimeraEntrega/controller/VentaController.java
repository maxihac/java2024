package edu.coderhouse.FacturacionPrimeraEntrega.controller;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Producto;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Venta;
import edu.coderhouse.FacturacionPrimeraEntrega.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
@Tag(name = "Venta",description = "Operaciones con  Ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/agregar")
    @Operation(summary = "Agregar Nueva Venta", description = "Agrega una nueva Venta al sistema")
    public ResponseEntity<Venta> agregarVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.agregarVenta(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }
    @GetMapping("/todos")     //TRAE TODOS LOS ventaS
    @Operation(summary = "Muestra todas la ventas", description = "Vea el detalle de todas las ventas del sistema")
    public List<Venta> obtenerTodosLasVentas() {
        return ventaService.obtenerTodosLasVentas();
    }
    @GetMapping("/buscar/{id}")
    @Operation(summary = "Busca venta por id", description = "Busca una venta por Id")
//    public Optional<Venta> buscarVenta(@PathVariable Long id) {
//        return ventaService.buscarVenta(id);
//    }
    public ResponseEntity<?> buscarVenta(@PathVariable Long id) {
        try {
            Venta venta = ventaService.buscarVenta(id);
            return ResponseEntity.ok(venta);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/borrar/{id}")
    @Operation(summary = "Borra una venta por Id", description = "Borra una venta del sistema")
   public ResponseEntity<String> borrarVenta(@PathVariable Long id) {
//        ventaService.borrarVenta(id);
//        return new ResponseEntity<>("Venta borrada correctamente", HttpStatus.OK);
//    }
        try {
            ventaService.borrarVenta(id);
            return new ResponseEntity<>("Venta borrada correctamente", HttpStatus.OK);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PutMapping("/actualizar/{id}")
    @Operation(summary = "Actualiza una venta por Id", description = "Modifica una venta del sistema")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody Venta ventaActualizada) {
        Venta venta = ventaService.actualizarVenta(id, ventaActualizada);
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }
}