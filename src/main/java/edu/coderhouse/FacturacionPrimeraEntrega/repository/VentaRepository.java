package edu.coderhouse.FacturacionPrimeraEntrega.repository;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository  extends JpaRepository<Venta, Long> {
}
