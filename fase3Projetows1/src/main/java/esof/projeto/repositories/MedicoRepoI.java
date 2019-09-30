package projetoengsof.engsoft.repositories;

import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projetoengsof.engsoft.models.Medico;


import java.util.Optional;



@Repository
public interface MedicoRepoI extends CrudRepository<Medico,Long> {
    //Optional<Medico> findByName(String name);
    Medico findByNome(String nome);

}

