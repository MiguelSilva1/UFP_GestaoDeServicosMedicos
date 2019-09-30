package esof.projeto.filters.medicoFilters;

import org.springframework.stereotype.Service;
import esof.projeto.filters.AndFilter;
import esof.projeto.filters.FilterI;
import esof.projeto.filters.FilterObject;
import esof.projeto.models.Medico;

import java.util.Set;

@Service
public class MedicoFilterService {
    public Set<Medico> filterMedico(Set<Medico> medicos, FilterObject filterObject) {
        FilterI<Medico> horaSaidaFilter = new HoraSaidaFilter(filterObject.getHoraSaida());
        FilterI<Medico> horaEntradaFilter = new HoraEntradaFilter(filterObject.getHoraEntrada());
        FilterI<Medico> horaSaidaAndHoraEntradaFilter = new AndFilter<>(horaSaidaFilter, horaEntradaFilter);
        FilterI<Medico> especialidadeFilter = new EspecialidadeFilter(filterObject.getEspecialidade());
        FilterI<Medico> especialidadeAndHoraEntradaAndHoraSaida
                = new AndFilter<>(horaSaidaAndHoraEntradaFilter, especialidadeFilter);
        FilterI<Medico> diaFilter = new DiaFilter(filterObject.getDia());
        FilterI<Medico> especialidadeAndHoraEntradaAndHoraSaidaAndDia
                = new AndFilter<>(especialidadeAndHoraEntradaAndHoraSaida, diaFilter);
        return especialidadeAndHoraEntradaAndHoraSaidaAndDia.filter(medicos);
    }
}
