package projetoengsof.engsoft.filters.medicoFiltros;

import projetoengsof.engsoft.models.Consulta;
import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Medico;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DiaFilter implements GenericoFiltro {

    private DayOfWeek dia ;

    public DiaFiltro(DayOfWeek dia){
        this.dia = dia;
    }


    @Override
    public Set<Generico> filter(Set<Generico> genericos) {
        if(dia==null)return genericos;
        Set<Generico> diaFiltro=new HashSet<>();
        for(Generico generico: genericos){
            for(Consulta consulta:generico.getConsultas()) {
                if (consulta.getDataHora().getDayOfWeek().equals(dia)) {
                    diaFiltro.add(generico);
                    break;
                }
            }
        }
        return diaFiltro;
    }

}
