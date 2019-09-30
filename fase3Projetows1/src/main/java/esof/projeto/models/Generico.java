package projetoengsof.engsoft.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Generico extends BaseModel{

    public String nome;

    public String endereco;

    public Integer idade;

    public String contacto;

    public String numeroProfissao;

    public String especialidade;

    public String profissao;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "generico")
    public Set<Consulta> consultas = new HashSet<>();

    @OneToMany
    public Set<Horario> horario = new HashSet<>();


    public boolean verificarSeExisteHorario(LocalDateTime dataPertendida) {

        for (Horario horario : this.horario) {
            if (horario.getDiaSemana().equals(dataPertendida.getDayOfWeek())) {
                if (dataPertendida.toLocalTime().isAfter(horario.getHoraInicio()) && dataPertendida.toLocalTime().isBefore(horario.getHoraFim().minusHours(1))) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean verificaSeMedicoTemConsultas(LocalDateTime dataPertendida) {

        if (verificarSeExisteHorario(dataPertendida)) {
            Iterator<Consulta> it = this.getConsultas().iterator();
            while (it.hasNext()) {
                Consulta cons = it.next();
                if (cons.getDataHora().isEqual(dataPertendida) || (cons.getDataHora().isBefore(dataPertendida) && cons.getDataHora().plusHours(1).isAfter(dataPertendida)) ) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }


    public void addHorario(Horario horario) {
        this.horario.add(horario);
//    horario.setMedico(this);
    }

    public void addConsulta(Consulta consulta) {
        if (verificarSeExisteHorario(consulta.getDataHora()) && verificaSeMedicoTemConsultas(consulta.getDataHora())) {
            this.consultas.add(consulta);
        }
    }

}
