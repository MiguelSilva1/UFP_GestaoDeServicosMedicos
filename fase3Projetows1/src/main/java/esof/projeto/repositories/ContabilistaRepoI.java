package projetoengsof.engsoft.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projetoengsof.engsoft.models.Contabilista;

@Repository
public interface ContabilistaRepoI extends CrudRepository<Contabilista,Long> {

}
