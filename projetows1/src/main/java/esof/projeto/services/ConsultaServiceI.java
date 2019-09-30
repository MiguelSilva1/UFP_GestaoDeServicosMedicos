package esof.projeto.services;

import esof.projeto.models.Consulta;
import esof.projeto.models.Medico;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public interface ConsultaServiceI {
    Set<Consulta> getAllConsultas();

    Set<Consulta> getConsultaData(LocalDateTime data);

    LocalDateTime StringToLocalDateTime(String data);

    boolean MarcarConsulta(Consulta novaConsulta, Medico medico);

    void saveConsulta(Consulta novaConsulta);

    Optional<Consulta> getConsultaById(Long id);

    void apagarConsulta(Long id);
}
