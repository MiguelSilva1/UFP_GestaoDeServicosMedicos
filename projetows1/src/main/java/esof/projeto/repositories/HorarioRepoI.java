package esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import esof.projeto.models.Horario;

@Repository
public interface HorarioRepoI extends CrudRepository<Horario, Long> {
}
