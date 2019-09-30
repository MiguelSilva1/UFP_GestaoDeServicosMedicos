package projetoengsof.engsoft.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.DayOfWeek;
import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Horario extends BaseModel {

    // @Autowired
    public DayOfWeek diaSemana;
    //@Autowired
    public LocalTime horaInicio;
    //@Autowired
    public LocalTime horaFim;



    public Horario(LocalTime horaInicio, LocalTime horaFim , DayOfWeek diaSemana) {

        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.diaSemana = diaSemana;
    }
}