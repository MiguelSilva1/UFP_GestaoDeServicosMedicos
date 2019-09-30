package esof.projetows2.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class Pessoa extends BaseModel {
    public String nome;
    public String endereco;
    public Integer idade;
    public String contacto;
}