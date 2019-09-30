package projetoengsof.engsoft.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoengsof.engsoft.filters.FilterObject;
import projetoengsof.engsoft.models.Consulta;
import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Medico;
import projetoengsof.engsoft.models.Utilizador;
import projetoengsof.engsoft.services.ConsultaServiceI;
import projetoengsof.engsoft.services.GenericoServiceI;
import projetoengsof.engsoft.services.UtilizadorServiceI;


import java.util.Optional;


@RestController
@RequestMapping("/consulta")
public class ConsultaController {


    private ConsultaServiceI consultaService;
    private UtilizadorServiceI utilizadorService;
    private GenericoServiceI genericoServiceI;


    public ConsultaController(ConsultaServiceI consultaService , UtilizadorServiceI utilizadorService , GenericoServiceI genericoServiceI){


        this.consultaService = consultaService;
        this.utilizadorService = utilizadorService;
        this.genericoServiceI = genericoServiceI;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Consulta> AllConsultas(){
        return consultaService.getAllConsultas();
    }



    @PostMapping(value = "/marcar/{id_utente}/{id_pessoa}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String marcarConsulta(@RequestBody Consulta consulta , @PathVariable("id_utente") Long id_utente , @PathVariable("id_pessoa") Long id_pessoa){


        Optional<Utilizador> utilizador = utilizadorService.getById(id_utente);
        Generico generico = genericoServiceI.getGenById(id_pessoa);

        if(consultaService.MarcarConsulta(consulta , generico)){

            generico.addConsulta(consulta);
            consulta.setGenerico(generico);
            consulta.setUtilizador(utilizador.get());
            utilizador.get().addConsulta(consulta);
            consultaService.saveConsulta(consulta);
            return "Adicionado com sucesso";

        }
        return "Nao adicionado";

    }




}
