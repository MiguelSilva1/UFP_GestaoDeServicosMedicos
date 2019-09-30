package esof.projeto.services;

import esof.projeto.filters.FilterObject;
import esof.projeto.models.Medico;

import java.util.Optional;
import java.util.Set;

public interface MedicoServiceI {
    Set<Medico> getAllMedicos();

    Medico getMedicoByName(String name);

    Set<Medico> getFilteredMedicos(FilterObject filterObject);

    boolean existeMedicoById(String id);

    void saveMedico(Medico medico);

    Optional<Medico> getMedicoById(Long id);

    void apagarById(Long id);
}
