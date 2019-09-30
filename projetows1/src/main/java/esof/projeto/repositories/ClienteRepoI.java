package esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import esof.projeto.models.Cliente;

@Repository
public interface ClienteRepoI extends CrudRepository<Cliente, Long> {
}
