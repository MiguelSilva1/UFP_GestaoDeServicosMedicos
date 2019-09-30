package esof.projeto.filters.medicoFilters;

import esof.projeto.models.Horario;
import esof.projeto.models.Medico;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class HoraSaidaFilter implements MedicoFilter {
    private LocalTime horaSaida;

    public HoraSaidaFilter(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }
    @Override
    public Set<Medico> filter(Set<Medico> medicos) {
        if (horaSaida == null) return medicos;

        Set<Medico> horaSaidaFilter = new HashSet<>();
        for (Medico m : medicos) {
            for (Horario h : m.getHorario()) {
                if (h.getHoraSaida().getHour() >= horaSaida.getHour()) {
                    horaSaidaFilter.add(m);
                    break;
                }
            }
        }
        return horaSaidaFilter;
    }
}