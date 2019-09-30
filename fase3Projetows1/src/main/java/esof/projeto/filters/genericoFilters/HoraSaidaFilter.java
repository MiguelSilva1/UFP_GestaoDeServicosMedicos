package projetoengsof.engsoft.filters.medicoFiltros;

import projetoengsof.engsoft.models.Consulta;
import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Horario;
import projetoengsof.engsoft.models.Medico;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class HoraSaidaFilter implements GenericoFiltro {

    private LocalTime horaFim;


    public HoraFimFiltro(LocalTime horaFim){
        this.horaFim = horaFim;
    }




    @Override
    public Set<Generico> filter(Set<Generico> genericos) {
        if(horaFim==null)return genericos;

        Set<Generico> horaFimFiltro =new HashSet<>();
        for(Generico generico:genericos){
            for(Horario horario:generico.getHorario()){
                if(horario.getHoraFim().getHour() >= horaFim.getHour()) {
                    horaFimFiltro.add(generico);
                    break;
                }
            }
        }
        return horaFimFiltro;
    }





}