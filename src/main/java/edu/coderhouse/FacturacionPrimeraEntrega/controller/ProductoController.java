package edu.coderhouse.FacturacionPrimeraEntrega.controller;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Producto;
import edu.coderhouse.FacturacionPrimeraEntrega.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/agregar")
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @GetMapping("/todos")     //TRAE TODOS LOS CLIENTES
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }


@GetMapping("/buscar/{id}")
public ResponseEntity<?> buscarProducto(@PathVariable Long id) {
    try {
        Producto producto = productoService.buscarProducto(id);
        return ResponseEntity.ok(producto);
    } catch (RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}


    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable Long id) {
        productoService.borrarProducto(id);
        return new ResponseEntity<>("Producto borrado correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        Producto producto = productoService.actualizarProducto(id, productoActualizado);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
}