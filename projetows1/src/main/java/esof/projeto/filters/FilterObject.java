package esof.projeto.filters;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class FilterObject {
    private String especialidade;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private DayOfWeek dia;
}
