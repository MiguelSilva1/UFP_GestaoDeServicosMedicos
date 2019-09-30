package ws2.projetows2.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class Pessoa extends BaseModel  {

  public String nome;

  public String endereco;

  public Integer idade;

  public String contacto;

}