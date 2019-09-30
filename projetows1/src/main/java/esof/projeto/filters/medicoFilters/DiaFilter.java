package esof.projeto.filters.medicoFilters;

import esof.projeto.models.Consulta;
import esof.projeto.models.Medico;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

public class DiaFilter implements MedicoFilter {
    private DayOfWeek dia;

    public DiaFilter(DayOfWeek dia) {
        this.dia = dia;
    }

    @Override
    public Set<Medico> filter(Set<Medico> medicos) {
        if (dia == null) return medicos;
        Set<Medico> diaFilter = new HashSet<>();
        for (Medico m : medicos) {
            for (Consulta c : m.getConsultas()) {
                if (c.getDataHora().getDayOfWeek().equals(dia)) {
                    diaFilter.add(m);
                    break;
                }
            }
        }
        return diaFilter;
    }
}
