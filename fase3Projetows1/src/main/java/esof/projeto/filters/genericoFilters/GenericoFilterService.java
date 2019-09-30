package projetoengsof.engsoft.filters.medicoFiltros;


import org.springframework.stereotype.Service;
import projetoengsof.engsoft.filters.AndFilter;
import projetoengsof.engsoft.filters.FilterI;
import projetoengsof.engsoft.filters.FilterObject;
import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Medico;
import projetoengsof.engsoft.models.Pessoa;

import java.util.Set;

@Service
public class GenericoFilterService {

    public Set<Generico> filterGenerico(Set<Generico> genericos, FilterObject filterObject) {



        FilterI<Generico>  horaFimFiltro = new HoraFimFiltro(filterObject.getHoraFim());
        FilterI<Generico>  horaInicioFiltro = new HoraInicioeFiltro(filterObject.getHoraInicio());
        FilterI<Generico> horaFimAndHoraInicioFiltro = new AndFilter<>(horaFimFiltro, horaInicioFiltro);

        FilterI<Generico>  especialidadeFilter = new EspecialidadeFiltro(filterObject.getEspecialidade());
        FilterI<Generico>  especialidadeAndHoraInicioAndHoraFim = new AndFilter<>(horaFimAndHoraInicioFiltro , especialidadeFilter);

        FilterI<Generico>  diaFiltro = new DiaFiltro(filterObject.getDia());
        FilterI<Generico> especialidadeAndHoraInicioAndHoraFimAndDia = new AndFilter<>(especialidadeAndHoraInicioAndHoraFim , diaFiltro);

        return especialidadeAndHoraInicioAndHoraFimAndDia.filter(genericos);
    }
}
