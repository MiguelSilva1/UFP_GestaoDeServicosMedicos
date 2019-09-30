package projetoengsof.engsoft.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Cliente extends Pessoa  {


    public String numeroUtente;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "utilizador")
    public Set<Consulta> consultas = new HashSet<>();



/*
  public void marcarConsulta(LocalDateTime ldt , Medico medico , String gabinete, float custo ) {

      if(medico.verificarSeExisteHorario(ldt)){
        if(medico.verificaSeMedicoTemConsultas(ldt)){
           Consulta novaConsulta = new Consulta(ldt , gabinete , custo , this , medico );
           consultas.add(novaConsulta);
           medico.getConsultas().add(novaConsulta);
        }
      }
  }*/


    public void addConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

}