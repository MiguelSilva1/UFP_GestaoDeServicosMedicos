package projetoengsof.engsoft.services;

import projetoengsof.engsoft.models.Consulta;
import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Medico;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public interface ConsultaServiceI {

    Set<Consulta> getAllConsultas();
    Set<Consulta> getConsultaData(LocalDateTime data);
    LocalDateTime StringToLocalDateTima(String data);
    boolean MarcarConsulta(Consulta novaConsulta , Generico generico);
    void saveConsulta(Consulta novaConsulta);
    Optional<Consulta> getConsultaById(Long id);
    void apagarConsulta(Long id);
}
