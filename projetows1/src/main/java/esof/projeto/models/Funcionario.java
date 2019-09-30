package esof.projeto.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Funcionario extends Pessoa {
    public String idFuncionario;
    public String cargo;
}