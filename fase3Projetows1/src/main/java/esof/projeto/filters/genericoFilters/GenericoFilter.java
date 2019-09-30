package projetoengsof.engsoft.filters.medicoFiltros;

import projetoengsof.engsoft.filters.FilterI;
import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Medico;

import java.util.Set;

public interface GenericoFilter extends FilterI<Generico> {
    Set<Generico> filter(Set<Generico> entities);
}
