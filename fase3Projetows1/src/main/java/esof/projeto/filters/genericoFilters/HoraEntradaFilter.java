package projetoengsof.engsoft.filters.medicoFiltros;

import projetoengsof.engsoft.models.Consulta;
import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Horario;
import projetoengsof.engsoft.models.Medico;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class HoraEntradaFilter implements GenericoFiltro {

    private LocalTime horaInicio;


    public HoraInicioeFiltro(LocalTime horaInicio){
        this.horaInicio = horaInicio;
    }



    @Override
    public Set<Generico> filter(Set<Generico> genericos) {
        if(horaInicio==null)return genericos;

        Set<Generico> horaInicioFiltro =new HashSet<>();
        for(Generico generico:genericos){
            for(Horario horario:generico.getHorario()){
                if(horario.getHoraInicio().getHour() <= horaInicio.getHour()) {
                    horaInicioFiltro.add(generico);
                    break;
                }
            }
        }
        return horaInicioFiltro;
    }


}
