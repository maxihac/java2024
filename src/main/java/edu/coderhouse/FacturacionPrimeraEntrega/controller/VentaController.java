package edu.coderhouse.FacturacionPrimeraEntrega.controller;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Venta;
import edu.coderhouse.FacturacionPrimeraEntrega.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/agregar")
    public ResponseEntity<Venta> agregarVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.agregarVenta(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }
    @GetMapping("/todos")     //TRAE TODOS LOS ventaS
    public List<Venta> obtenerTodosLasVentas() {
        return ventaService.obtenerTodosLasVentas();
    }
    @GetMapping("/buscar/{id}")
    public Optional<Venta> buscarVenta(@PathVariable Long id) {
        return ventaService.buscarVenta(id);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarVenta(@PathVariable Long id) {
        ventaService.borrarVenta(id);
        return new ResponseEntity<>("Venta borrada correctamente", HttpStatus.OK);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody Venta ventaActualizada) {
        Venta venta = ventaService.actualizarVenta(id, ventaActualizada);
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }
}