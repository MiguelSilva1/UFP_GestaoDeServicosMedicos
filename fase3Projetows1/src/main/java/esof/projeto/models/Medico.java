package projetoengsof.engsoft.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class Medico extends Generico implements Serializable {

    @Override
    public int hashCode(){
        int i = getId().intValue();
        return i;
    }


}