package esof.projeto.filters.medicoFilters;

import esof.projeto.models.Medico;

import java.util.Set;
import java.util.stream.Collectors;

public class EspecialidadeFilter implements MedicoFilter {
    private String especialidade;

    public EspecialidadeFilter(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public Set<Medico> filter(Set<Medico> medicos) {
        if (especialidade == null) return medicos;
        return medicos.stream()
                .filter(medico -> medico.getEspecialidade().equalsIgnoreCase(especialidade))
                .collect(Collectors.toSet());
    }
}
