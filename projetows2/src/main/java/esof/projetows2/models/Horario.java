package esof.projetows2.models;

import lombok.*;

import javax.persistence.Entity;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Horario extends BaseModel {
    public DayOfWeek diaSemana;
    public LocalTime horaEntrada;
    public LocalTime horaSaida;

    public Horario(LocalTime horaEntrada, LocalTime horaSaida, DayOfWeek diaSemana) {
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.diaSemana = diaSemana;
    }
}