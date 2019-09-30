package esof.projeto.filters.medicoFilters;

import esof.projeto.models.Horario;
import esof.projeto.models.Medico;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class HoraEntradaFilter implements MedicoFilter {
    private LocalTime horaEntrada;

    public HoraEntradaFilter(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    @Override
    public Set<Medico> filter(Set<Medico> medicos) {
        if (horaEntrada == null) return medicos;

        Set<Medico> horaEntradaFilter = new HashSet<>();
        for (Medico m : medicos) {
            for (Horario h : m.getHorario()) {
                if (h.getHoraEntrada().getHour() <= horaEntrada.getHour()) {
                    horaEntradaFilter.add(m);
                    break;
                }
            }
        }
        return horaEntradaFilter;
    }
}
