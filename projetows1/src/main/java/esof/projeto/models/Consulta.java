package esof.projeto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Consulta extends BaseModel {
    public LocalDateTime dataHora;
    public String salaConsulta;
    public String nomeMedico;
    public float precoConsulta;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    public Cliente cliente;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    public Medico medico;

    public Consulta(LocalDateTime dataHora, String salaConsulta, float precoConsulta, Cliente cliente, Medico medico,
                    String nomeMedico) {
        this.dataHora = dataHora;
        this.salaConsulta = salaConsulta;
        this.precoConsulta = precoConsulta;
        this.cliente = cliente;
        this.medico = medico;
        this.nomeMedico = nomeMedico;
    }
}