package projetoengsof.engsoft.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projetoengsof.engsoft.models.Advogado;

@Repository
public interface AdvogadoRepoI extends CrudRepository<Advogado,Long> {

}
