package esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import esof.projeto.models.Medico;

@Repository
public interface MedicoRepoI extends CrudRepository<Medico, Long> {
}

