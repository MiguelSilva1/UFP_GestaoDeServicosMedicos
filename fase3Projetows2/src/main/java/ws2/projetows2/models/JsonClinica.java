package ws2.projetows2.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Data
public class JsonClinica {

    public JsonNode tipo;
    public String nomeDepartamento;

}
