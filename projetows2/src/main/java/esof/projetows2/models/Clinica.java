package esof.projetows2.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Clinica extends BaseModel {
    private String nome;
    private String morada;
    private String contacto;
    private String email;

    public Clinica(String nome, String email, String contacto, String morada) {
        this.nome = nome;
        this.email = email;
        this.contacto = contacto;
        this.morada = morada;
    }
}