package projetoengsof.engsoft.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projetoengsof.engsoft.models.Funcionario;

import java.util.Optional;

@Repository
public interface FuncionarioRepoI extends CrudRepository<Funcionario,Long> {
    //Optional<Consulta> findByName(String name);
}