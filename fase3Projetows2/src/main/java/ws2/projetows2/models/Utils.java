package ws2.projetows2.models;

import java.util.HashMap;
import java.util.Map;

public class Utils
{
    static Map<String, String> map = new HashMap<String, String>();

    static {
        map.put("clinica", "http://localhost:8080");
       // map.put("escritorio", "http://localhost:8081");
    }

    public static Map<String,String> getMap(){
        return map;
    }
}
