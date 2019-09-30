package esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import esof.projeto.models.Funcionario;

@Repository
public interface FuncionarioRepoI extends CrudRepository<Funcionario, Long> {
}