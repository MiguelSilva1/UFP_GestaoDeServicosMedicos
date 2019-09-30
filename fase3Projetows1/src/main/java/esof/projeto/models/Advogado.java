package projetoengsof.engsoft.models;


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
public class Advogado extends Generico  {

    @Override
    public int hashCode(){
        int i = getId().intValue();
        return i;
    }

}
