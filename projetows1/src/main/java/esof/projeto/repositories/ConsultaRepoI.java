package esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import esof.projeto.models.Consulta;

@Repository
public interface ConsultaRepoI extends CrudRepository<Consulta, Long> {
}