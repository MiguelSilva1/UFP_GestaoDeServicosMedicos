package esof.projeto.services;

import esof.projeto.models.Cliente;

import java.util.Optional;
import java.util.Set;

public interface ClienteServiceI {
    Set<Cliente> getAllClientees();

    Optional<Cliente> getClienteByIdCliente(String idCliente);

    Optional<Cliente> getById(Long id);
}
