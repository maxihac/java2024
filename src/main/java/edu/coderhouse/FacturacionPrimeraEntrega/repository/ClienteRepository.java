package edu.coderhouse.FacturacionPrimeraEntrega.repository;


import edu.coderhouse.FacturacionPrimeraEntrega.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { }