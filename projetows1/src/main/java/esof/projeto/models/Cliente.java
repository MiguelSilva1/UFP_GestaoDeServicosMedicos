package esof.projeto.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Cliente extends Pessoa {
    public String idCliente;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
    public Set<Consulta> consultas = new HashSet<>();

    public void addConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }
}