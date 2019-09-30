package projetoengsof.engsoft.filters.medicoFiltros;

import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Medico;

import java.util.Set;
import java.util.stream.Collectors;

public class EspecialidadeFilter implements GenericoFiltro{

    private String especialidade;

    public EspecialidadeFiltro(String especialidade){
        this.especialidade = especialidade;
    }

    @Override
    public Set<Generico> filter(Set<Generico> genericos) {
        if(especialidade==null)return genericos;
        return genericos.stream()
                .filter(medico -> medico.getEspecialidade().equalsIgnoreCase(especialidade))
                .collect(Collectors.toSet());
    }


}
