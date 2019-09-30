package esof.projetows2.models;

import java.util.HashMap;
import java.util.Map;

public class Mapeamento {
    static Map<String, String> map = new HashMap<String, String>();

    static {
        map.put("clinica1", "http://localhost:8080");
        map.put("clinica2", "http://localhost:8081");
    }

    public static Map<String, String> getMap() {
        return map;
    }
}
