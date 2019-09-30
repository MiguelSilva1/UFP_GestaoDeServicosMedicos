package esof.projetows2.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import esof.projetows2.models.Consulta;
import esof.projetows2.models.JsonClinica;
import esof.projetows2.models.Mapeamento;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

@Controller
public class ConsultaController {
    private Logger logger = LoggerFactory.getLogger(ConsultaController.class);

    @GetMapping(value = "/medico", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Set<JsonClinica> getAllMedicos() throws JsonParseException, IOException {
        Set<JsonClinica> medicosClinica = new HashSet<>();
        for (String key : Mapeamento.getMap().keySet()) {
            JsonClinica medicosClinicaTemp = new JsonClinica();
            String path = Mapeamento.getMap().get(key);
            path = path.concat("/medico/");
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
            ResponseEntity<String> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(responseEntity.getBody());
            medicosClinicaTemp.setTipo(actualObj);
            medicosClinicaTemp.setNomeClinica(key);
            medicosClinica.add(medicosClinicaTemp);
        }
        return medicosClinica;
    }

    @GetMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Set<JsonClinica> getAllConsultas() throws JsonParseException, IOException {
        Set<JsonClinica> consultaClinica = new HashSet<>();
        for (String key : Mapeamento.getMap().keySet()) {
            JsonClinica consultaClinicaTemp = new JsonClinica();
            String path = Mapeamento.getMap().get(key);
            path = path.concat("/consulta/");
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
            ResponseEntity<String> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(responseEntity.getBody());
            consultaClinicaTemp.setTipo(actualObj);
            consultaClinicaTemp.setNomeClinica(key);
            consultaClinica.add(consultaClinicaTemp);
        }
        return consultaClinica;
    }

    @GetMapping(value = "/consulta/{nomeclinica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getAllConsultas(@PathVariable("nomeclinica") String nomeclinica) {
        String path = Mapeamento.getMap().get(nomeclinica).concat("/consulta/");
        logger.info(path);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
        ResponseEntity<Iterable> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, Iterable.class);
        return responseEntity.getBody();
    }

    @GetMapping(value = "/medico/{nomeclinica}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getAllMedicosClinica(@PathVariable("nomeclinica") String nomeclinica) {
        String path = Mapeamento.getMap().get(nomeclinica).concat("/medico/");
        logger.info(path);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
        ResponseEntity<Iterable> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, Iterable.class);
        return responseEntity.getBody();
    }

    @GetMapping(value = "/filter/{nomeclinica}/{filter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getAllFiltrosMedicosClinica(@PathVariable("nomeclinica") String nomeclinica, @PathVariable("filter") String filter) {
        String path = Mapeamento.getMap().get(nomeclinica).concat("/medico").concat("?").concat(filter);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
        ResponseEntity<Iterable> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, Iterable.class);
        return responseEntity.getBody();
    }

    @PostMapping(value = "/marcar/{nomeclinica}/{idcliente}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String marcarConsulta(@RequestBody Consulta consulta, @PathVariable("nomeclinica") String nomeclinica, @PathVariable("idcliente") String idcliente) {
        String path = Mapeamento.getMap().get(nomeclinica).concat("/consulta/marcar/").concat(idcliente);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Consulta> bodyRequest = new HttpEntity<>(consulta, headers);
        ResponseEntity<String> responseEntity = makeRequest(path, HttpMethod.POST, bodyRequest, String.class);
        return responseEntity.getBody();
    }

    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, request, responseType);
    }

}