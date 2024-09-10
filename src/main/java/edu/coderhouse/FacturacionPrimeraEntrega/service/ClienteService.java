package edu.coderhouse.FacturacionPrimeraEntrega.service;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Cliente;
import edu.coderhouse.FacturacionPrimeraEntrega.model.Producto;
import edu.coderhouse.FacturacionPrimeraEntrega.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente agregarCliente(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            // Registrar el error
            System.err.println("Error al guardar el cliente: " + e.getMessage());
            throw new RuntimeException("Error al guardar el cliente", e);
        }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }
    //public Optional<Cliente> buscarCliente(Long id) {
    //    return clienteRepository.findById(id);
   // }
    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    public void borrarCliente(Long id) {

            Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            clienteRepository.delete(cliente);

    }
    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setApellido(clienteActualizado.getApellido());
        clienteExistente.setDni(clienteActualizado.getDni());
        clienteExistente.setEmail(clienteActualizado.getEmail());

        return clienteRepository.save(clienteExistente);
    }
}




