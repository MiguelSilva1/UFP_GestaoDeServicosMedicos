package projetoengsof.engsoft.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Getter
@Setter
@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Consulta extends BaseModel {

    public LocalDateTime dataHora;

    public String gabinete;

    public String pessoa_nome;

    public float custo;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    public Utilizador utilizador;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    public Generico generico;



    public Consulta(LocalDateTime dataHora, String gabinete, float custo, Utilizador utilizador, Generico generico , String pessoa_nome) {

        this.dataHora = dataHora;
        this.gabinete = gabinete;
        this.custo = custo;
        this.utilizador = utilizador;
        this.generico  = generico;
        this.pessoa_nome = pessoa_nome;

    }



}