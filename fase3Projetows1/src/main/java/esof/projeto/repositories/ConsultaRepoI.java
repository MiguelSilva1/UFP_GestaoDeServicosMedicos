package projetoengsof.engsoft.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projetoengsof.engsoft.models.Consulta;

import java.util.Optional;

@Repository
public interface ConsultaRepoI extends CrudRepository<Consulta,Long> {
    //Optional<Consulta> findByName(String name);
    //Iterable<Consulta> findAllByMedicoAndCusto();
}