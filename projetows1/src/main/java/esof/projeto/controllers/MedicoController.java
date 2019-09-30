package esof.projeto.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import esof.projeto.filters.FilterObject;
import esof.projeto.models.Medico;
import esof.projeto.services.MedicoServiceI;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private MedicoServiceI medicoService;
    private Logger logger = LoggerFactory.getLogger(MedicoController.class);

    public MedicoController(MedicoServiceI medicoService) {
        this.medicoService = medicoService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Medico> getAllMedicos(@ModelAttribute FilterObject filterObject) {
        logger.info(filterObject.toString());
        return medicoService.getFilteredMedicos(filterObject);
    }

    @RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Medico getById(@PathVariable("nome") String nome) {
        return medicoService.getMedicoByName(nome);
    }
}
