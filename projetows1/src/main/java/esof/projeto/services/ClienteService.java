package esof.projeto.services;

import org.springframework.stereotype.Service;
import esof.projeto.models.Cliente;
import esof.projeto.repositories.ClienteRepoI;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ClienteService implements ClienteServiceI {
    private ClienteRepoI clienteRepo;

    public ClienteService(ClienteRepoI clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public Set<Cliente> getAllClientees() {
        Set<Cliente> clientees = new HashSet<>();
        for (Cliente cliente : this.clienteRepo.findAll()) {
            clientees.add(cliente);
        }
        return Collections.unmodifiableSet(clientees);
    }

    @Override
    public Optional<Cliente> getClienteByIdCliente(String idCliente) {
        for (Cliente cliente : this.clienteRepo.findAll()) {
            if (cliente.getIdCliente().equalsIgnoreCase(idCliente)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Cliente> getById(Long id) {
        return clienteRepo.findById(id);
    }
}

