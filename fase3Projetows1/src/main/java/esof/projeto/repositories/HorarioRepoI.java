package projetoengsof.engsoft.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projetoengsof.engsoft.models.Consulta;
import projetoengsof.engsoft.models.Horario;

@Repository
public interface HorarioRepoI  extends CrudRepository<Horario,Long> {

}
