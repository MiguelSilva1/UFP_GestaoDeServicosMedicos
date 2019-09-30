package projetoengsof.engsoft.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projetoengsof.engsoft.models.Medico;
import projetoengsof.engsoft.models.Utilizador;

import java.util.Optional;

@Repository
public interface ClienteRepoI extends CrudRepository<Utilizador,Long> {
    //Optional<Utilizador> findByName(String name);
    Utilizador findByNome(String nome);
}
