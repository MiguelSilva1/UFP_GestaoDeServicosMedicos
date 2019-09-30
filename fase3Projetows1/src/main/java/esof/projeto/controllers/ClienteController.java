package projetoengsof.engsoft.controllers;


import org.springframework.http.MediaType;
import org.springframework.ui.context.support.UiApplicationContextUtils;
import org.springframework.web.bind.annotation.*;
import projetoengsof.engsoft.models.Funcionario;
import projetoengsof.engsoft.models.Medico;
import projetoengsof.engsoft.models.Utilizador;
import projetoengsof.engsoft.services.FuncionarioServiceI;
import projetoengsof.engsoft.services.UtilizadorServiceI;

import java.util.Optional;

@RestController
@RequestMapping("/utilizador")
public class ClienteController  {

    UtilizadorServiceI utilizadorService;

    public UtilizadorController(UtilizadorServiceI utilizadorService){
        this.utilizadorService = utilizadorService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Utilizador> AllUtilizadores(){
        return utilizadorService.getAllUtilizadores();
    }


    @RequestMapping(value="/{numero}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Utilizador getByNumeroUtente(@PathVariable("numero") String numero){
        Optional<Utilizador> utilizador = utilizadorService.getUtilizadorByNumeroUtente(numero);
        return utilizador.orElse(null);
    }

    @RequestMapping(value="/getid/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Optional<Utilizador> getById(@PathVariable("id") Long id){

        return utilizadorService.getById(id);
    }


}
