package esof.projetows2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Entity
@NoArgsConstructor
public class Consulta extends BaseModel {
    public LocalDateTime dataHora;
    public String gabinete;
    public String nomeMedico;
    public float custo;
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

    public Consulta(LocalDateTime dataHora, String gabinete, float custo, Cliente cliente, Medico medico, String nomeMedico) {
        this.dataHora = dataHora;
        this.gabinete = gabinete;
        this.custo = custo;
        this.cliente = cliente;
        this.medico = medico;
        this.nomeMedico = nomeMedico;
    }
}