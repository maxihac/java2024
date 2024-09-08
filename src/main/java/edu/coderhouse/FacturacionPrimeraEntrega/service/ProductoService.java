package edu.coderhouse.FacturacionPrimeraEntrega.service;


import edu.coderhouse.FacturacionPrimeraEntrega.model.Cliente;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Producto;
import edu.coderhouse.FacturacionPrimeraEntrega.repository.ClienteRepository;
import edu.coderhouse.FacturacionPrimeraEntrega.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto agregarProducto(Producto producto) {
        try {
            return productoRepository.save(producto);
        } catch (Exception e) {
            // Registrar el error
            System.err.println("Error al guardar el producto: " + e.getMessage());
            throw new RuntimeException("Error al guardar el producto", e);
        }
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

public Producto buscarProducto(Long id) {
    return productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
}


//    public void borrarProducto(Long id) {
//        productoRepository.deleteById(id);
//    }
    public void borrarProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoRepository.delete(producto);
    }
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("producto no encontrado"));
        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setStock(productoActualizado.getStock());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        return productoRepository.save(productoExistente);
    }
}
