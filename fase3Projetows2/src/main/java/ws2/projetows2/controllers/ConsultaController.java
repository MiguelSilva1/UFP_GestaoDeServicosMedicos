package ws2.projetows2.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ws2.projetows2.models.Consulta;
import ws2.projetows2.models.JsonClinica;
import ws2.projetows2.models.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.*;


@Controller
public class ConsultaController {

    private Logger logger= LoggerFactory.getLogger(ConsultaController.class);

    @GetMapping(value = "/generico", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Set<JsonClinica> getAllPessoas() throws JsonParseException, IOException {

        Set<JsonClinica> pessoas = new HashSet<>();


        for(String key : Utils.getMap().keySet()) {

            JsonClinica pessoasTemp = new JsonClinica();

            String path = Utils.getMap().get(key);
            path = path .concat("/generico/");


            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);

            ResponseEntity<String> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(responseEntity.getBody());

            pessoasTemp.setTipo(actualObj);
            pessoasTemp.setNomeDepartamento(key);
            pessoas.add(pessoasTemp);

        }
        return  pessoas;
    }


    @GetMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Set<JsonClinica> getAllConsultas() throws JsonParseException, IOException {

        Set<JsonClinica> consultaClinica = new HashSet<>();


        for(String key : Utils.getMap().keySet()) {

            JsonClinica consultaClinicaTemp = new JsonClinica();

            String path = Utils.getMap().get(key);
            path = path .concat("/consulta/");


            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);

            ResponseEntity<String> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(responseEntity.getBody());

            consultaClinicaTemp.setTipo(actualObj);
            consultaClinicaTemp.setNomeDepartamento(key);
            consultaClinica.add(consultaClinicaTemp);

        }
        return consultaClinica;
    }



    @GetMapping(value = "/consulta/{nomeDepartamento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getAllConsultas(@PathVariable("nomeDepartamento") String nomeDepartamento) {
        //setExample();
        String path = Utils.getMap().get(nomeDepartamento) .concat("/consulta/");
        logger.info(path);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
        ResponseEntity<Iterable> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, Iterable.class);
        return responseEntity.getBody();
    }

    @GetMapping(value = "/generico/{nomeDepartamento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getAllMedicosClinica(@PathVariable("nomeDepartamento") String nomeDepartamento) {
        //setExample();
        String path = Utils.getMap().get(nomeDepartamento) .concat("/generico/");
        logger.info(path);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
        ResponseEntity<Iterable> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, Iterable.class);
        return responseEntity.getBody();
    }


    @GetMapping(value = "/filtro/{nomeClinica}/{profissao}/{filtro}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable getAllFiltrosMedicosClinica(@PathVariable("nomeClinica") String nomeClinica ,@PathVariable("profissao") String profissao, @PathVariable("filtro") String filtro) {

        String path = Utils.getMap().get(nomeClinica) .concat("/generico").concat("/").concat(profissao).concat("?").concat(filtro);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> nullBodyRequest = new HttpEntity<>(null, headers);
        ResponseEntity<Iterable> responseEntity = makeRequest(path, HttpMethod.GET, nullBodyRequest, Iterable.class);
        return responseEntity.getBody();
    }

    /*
    @PostMapping(value = "/marcar/{nomeClinica}/{id_utente}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String marcarConsulta(@RequestBody Consulta consulta , @PathVariable("nomeClinica") String nomeClinica , @PathVariable("id_utente") String id_utente){

        String path = Utils.getMap().get(nomeClinica) .concat("/consulta/marcar/").concat(id_utente);


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Consulta> bodyRequest = new HttpEntity<>(consulta, headers);

        ResponseEntity<String> responseEntity = makeRequest(path, HttpMethod.POST, bodyRequest, String.class);


        return responseEntity.getBody();
    }*/







    private ResponseEntity makeRequest(String path, HttpMethod method, HttpEntity request, Class responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, method, request, responseType);
    }

}