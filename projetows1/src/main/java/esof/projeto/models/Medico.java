package esof.projeto.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Medico extends Pessoa implements Serializable {
    public String idMedico;
    public String especialidade;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "medico")
    public Set<Consulta> consultas = new HashSet<>();
    @OneToMany
    public Set<Horario> horario = new HashSet<>();

    public boolean verificarSeExisteHorario(LocalDateTime dataPretendida) {
        for (Horario h : this.horario) {
            if (h.getDiaSemana().equals(dataPretendida.getDayOfWeek())) {
                if (dataPretendida.toLocalTime().isAfter(h.getHoraEntrada())
                        && dataPretendida.toLocalTime().isBefore(h.getHoraSaida().minusHours(1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificaSeMedicoTemConsultas(LocalDateTime dataPretendida) {
        if (verificarSeExisteHorario(dataPretendida)) {
            Iterator<Consulta> it = this.getConsultas().iterator();
            while (it.hasNext()) {
                Consulta cons = it.next();
                if (cons.getDataHora().isEqual(dataPretendida) || (cons.getDataHora().isBefore(dataPretendida)
                        && cons.getDataHora().plusHours(1).isAfter(dataPretendida))) {
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
    }

    public void addConsulta(Consulta consulta) {
        if (verificarSeExisteHorario(consulta.getDataHora()) && verificaSeMedicoTemConsultas(consulta.getDataHora())) {
            this.consultas.add(consulta);
        }
    }
}