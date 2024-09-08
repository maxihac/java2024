package edu.coderhouse.FacturacionPrimeraEntrega.service;

import edu.coderhouse.FacturacionPrimeraEntrega.model.Venta;
import edu.coderhouse.FacturacionPrimeraEntrega.model.VentaProducto;
import edu.coderhouse.FacturacionPrimeraEntrega.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public Venta agregarVenta(Venta venta) {
        try {
            // Establecer la relación entre Venta y VentaProducto
            for (VentaProducto vp : venta.getVentaProductos()) {
                vp.setVenta(venta);
            }
            return ventaRepository.save(venta);
        } catch (Exception e) {
            // Registrar el error
            System.err.println("Error al guardar la venta: " + e.getMessage());
            throw new RuntimeException("Error al guardar la venta", e);
        }
    }


    public List<Venta> obtenerTodosLasVentas() {
        return ventaRepository.findAll();
    }
    public Optional<Venta> buscarVenta(Long id) {
        return ventaRepository.findById(id);
    }


    public void borrarVenta(Long id) {
        ventaRepository.deleteById(id);
    }



    public Venta actualizarVenta(Long id, Venta ventaActualizado) {
        Venta ventaExistente = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        ventaExistente.setTipofactura(ventaActualizado.getTipofactura());
        ventaExistente.setFactura(ventaActualizado.getFactura());
        ventaExistente.setFecha(ventaActualizado.getFecha());
        ventaExistente.setTotal(ventaActualizado.getTotal());
        return ventaRepository.save(ventaExistente);
    }
}
