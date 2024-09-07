package edu.coderhouse.FacturacionPrimeraEntrega.repository;

import edu.coderhouse.FacturacionPrimeraEntrega.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
