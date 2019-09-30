package esof.projeto.filters.medicoFilters;

import esof.projeto.filters.FilterI;
import esof.projeto.models.Medico;

import java.util.Set;

public interface MedicoFilter extends FilterI<Medico> {
    Set<Medico> filter(Set<Medico> entities);
}
