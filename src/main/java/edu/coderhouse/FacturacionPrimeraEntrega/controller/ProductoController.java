package edu.coderhouse.FacturacionPrimeraEntrega.controller;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Cliente;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Producto;
import edu.coderhouse.FacturacionPrimeraEntrega.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/productos")
@Tag(name = "Producto",description = "Operaciones con  Productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/agregar")
    @Operation(summary = "Agregar Nuevo Producto", description = "Agrega un nuevo Producto al sistema")

    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @GetMapping("/todos")//TRAE TODOS LOS PRODUCTOS
    @Operation(summary = "Muestra todos los productos", description = "Muestra el detalle de todos los productos")
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }


    @GetMapping("/buscar/{id}")
    @Operation(summary = "Busca producto por Id", description = "Busca producto y lo devueve si es valido")

    public ResponseEntity<?> buscarProducto(@PathVariable Long id) {
        try {
            Producto producto = productoService.buscarProducto(id);
            return ResponseEntity.ok(producto);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


    @DeleteMapping("/borrar/{id}")
    @Operation(summary = "Borra un producto por Id", description = "Borra un producto si encuentra el id sino da 404 producto no encontrado")
    public ResponseEntity<String> borrarProducto(@PathVariable Long id) {

        try {
            productoService.borrarProducto(id);
            return new ResponseEntity<>("Producto borrado correctamente", HttpStatus.OK);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PutMapping("/actualizar/{id}")
    @Operation(summary = "Actualiza producto por Id", description = "Actualiza un producto si encuentra el id ")

    public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        try {
            Producto producto = productoService.actualizarProducto(id, productoActualizado);
            return ResponseEntity.ok(producto);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado. Por favor, pruebe con otro ID.");
        }
    }
}