package projetoengsof.engsoft.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import projetoengsof.engsoft.filters.FilterObject;
import projetoengsof.engsoft.models.Generico;
import projetoengsof.engsoft.models.Medico;
import projetoengsof.engsoft.models.Pessoa;
import projetoengsof.engsoft.services.GenericoService;
import projetoengsof.engsoft.services.GenericoServiceI;

import java.util.Set;


@RestController
@RequestMapping("/generico")
public class GenericoController {

    private GenericoServiceI genericoServiceI;



    public GenericoController(GenericoServiceI genericoServiceI){
        this.genericoServiceI = genericoServiceI;
    }



    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Set<Generico> AllPessoasDeTodasAsProfissoes(){
        return genericoServiceI.getALL();
    }



    @RequestMapping(value= "/{profissao}" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Generico> getAllPessoas(@ModelAttribute FilterObject filterObject , @PathVariable("profissao") String profissao){

        return genericoServiceI.getFilteredGenericos(filterObject,profissao);
    }


}
